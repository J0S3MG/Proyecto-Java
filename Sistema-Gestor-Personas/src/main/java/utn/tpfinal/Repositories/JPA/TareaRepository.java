package utn.tpfinal.Repositories.JPA;
import org.springframework.data.jpa.repository.JpaRepository;
import utn.tpfinal.Models.Persona;
import utn.tpfinal.Models.Tarea;
import java.util.List;

// JpaRepository<TipoDeEntidad, TipoDeIdDeLaEntidad>
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByPersonaId(Long personaId);
    long countByPersona(Persona persona);
}