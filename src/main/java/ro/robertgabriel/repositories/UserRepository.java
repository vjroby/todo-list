package ro.robertgabriel.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.robertgabriel.entities.User;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, String> {

    List<User> findByEmail(String email);

    List<User> findByName(String name);
}
