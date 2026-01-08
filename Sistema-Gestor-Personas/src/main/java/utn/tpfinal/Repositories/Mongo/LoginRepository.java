package utn.tpfinal.Repositories.Mongo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.mongodb.repository.MongoRepository;
import utn.tpfinal.Models.LoginCredential;
import java.util.Optional;

public interface LoginRepository extends MongoRepository<LoginCredential, String> {
    Optional<LoginCredential> findByEmailAndPassword(String email, String password);
    Optional<LoginCredential> findByEmail(String email);
    Optional<LoginCredential> findByPersonaId(Long personaId);
    void deleteByPersonaId(Long personaId);
    @CacheEvict(value = "loginCache", key = "#email")
    void deleteByEmail(String email);
}