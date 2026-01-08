package utn.tpfinal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableJpaRepositories(basePackages = "utn.tpfinal.Repositories.JPA") //Crea una subcarpeta 'jpa' para tus repositorios JPA
@EnableMongoRepositories(basePackages = "utn.tpfinal.Repositories.Mongo") //Crea una subcarpeta 'mongo' para tus repositorios Mongo
@EnableCaching
@SpringBootApplication
public class SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }

}