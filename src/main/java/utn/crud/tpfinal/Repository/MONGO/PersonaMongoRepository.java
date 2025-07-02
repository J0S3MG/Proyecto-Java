package utn.crud.tpfinal.Repository.MONGO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.mongodb.repository.MongoRepository;
import utn.crud.tpfinal.Models.LoginCredential;
import java.util.List;
import java.util.Optional;

public interface PersonaMongoRepository extends MongoRepository<LoginCredential, String> {
    Optional<LoginCredential> findByEmailAndPassword(String email, String password);
    Optional<LoginCredential> findByEmail(String email);
    Optional<LoginCredential> findByPersonaId(Long personaId);
    void deleteByPersonaId(Long personaId);
    @CacheEvict(value = "loginCache", key = "#email")
    void deleteByEmail(String email);
}
