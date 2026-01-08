package utn.tpfinal.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import utn.tpfinal.Models.LoginCredential;
import utn.tpfinal.Models.Persona;
import utn.tpfinal.Repositories.Mongo.LoginRepository;
import utn.tpfinal.Repositories.JPA.PersonaRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepo;

    @Autowired
    private LoginRepository mongoRepo;

    @Cacheable(value = "loginCache", key = "#email + '-' + #password")
    public Optional<LoginCredential> login(String email, String password) {
        Optional<LoginCredential> foundCredential = mongoRepo.findByEmailAndPassword(email, password);
        return foundCredential;
    }

    public List<Persona> getAll() {
        List<Persona> personas = personaRepo.findAll();
        // Para cada persona, cargar su email y password desde MongoDB
        return personas.stream()
                .map(this::loadCredentialsForPersona)
                .collect(Collectors.toList());
    }

    public Optional<Persona> getById(Long id) {
        Optional<Persona> personaOptional = personaRepo.findById(id);
        personaOptional.ifPresent(this::loadCredentialsForPersona);
        return personaOptional;
    }

    //METODO para cargar email/password desde MongoDB.
    private Persona loadCredentialsForPersona(Persona persona) {
        if (persona != null && persona.getId() != null) {
            Optional<LoginCredential> credentialOptional = mongoRepo.findByPersonaId(persona.getId());
            if (credentialOptional.isPresent()) {
                LoginCredential credential = credentialOptional.get();
                persona.setEmail(credential.getEmail());
            }
        }
        return persona;
    }

    @CacheEvict(value = "loginCache", key = "#p.email", beforeInvocation = false)
    @CachePut(value = "persona", key = "#p.id")
    public Persona save(Persona p) {
        Persona savedPersona = personaRepo.save(p);

        if (p.getEmail() != null && !p.getEmail().isEmpty()) {
            Optional<LoginCredential> existingCredential = mongoRepo.findByEmail(p.getEmail());
            LoginCredential credentialToSave;

            if (existingCredential.isPresent()) {
                credentialToSave = existingCredential.get();
                if (p.getPassword() != null && !p.getPassword().isEmpty()) {
                    credentialToSave.setPassword(p.getPassword());
                }
            } else {
                credentialToSave = new LoginCredential();
                credentialToSave.setEmail(p.getEmail());
                credentialToSave.setPassword(p.getPassword());
            }
            credentialToSave.setPersonaId(savedPersona.getId());
            mongoRepo.save(credentialToSave);
        } else {
            System.out.println("Advertencia: Persona guardada sin email para credenciales de login.");
        }
        return savedPersona;
    }

    @CacheEvict(value = "persona", key = "#id")
    public void delete(Long id) {
        Optional<Persona> personaOptional = personaRepo.findById(id);

        if (personaOptional.isPresent()) {
            personaRepo.deleteById(id);

            Optional<LoginCredential> loginCredentialOptional = mongoRepo.findByPersonaId(id);

            if (loginCredentialOptional.isPresent()) {
                LoginCredential credentialToDelete = loginCredentialOptional.get();
                mongoRepo.deleteByEmail(credentialToDelete.getEmail());
            } else {
                System.out.println("Advertencia: No se encontró credencial de login en MongoDB para Persona ID: " + id);
            }
        } else {
            System.out.println("Advertencia: Persona con ID " + id + " no encontrada para eliminar.");
        }
    }
}
