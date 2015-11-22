package ro.robertgabriel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.robertgabriel.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    Role findByName(String name);

    @Override
    public void delete(Role role);
}
