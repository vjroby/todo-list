package ro.robertgabriel.repositories;

import org.springframework.stereotype.Repository;
import ro.robertgabriel.entities.Config;

@Repository
public interface ConfigRepository extends MyBaseRepository<Config, String> {

    Config findOneByKey(String key);
}
