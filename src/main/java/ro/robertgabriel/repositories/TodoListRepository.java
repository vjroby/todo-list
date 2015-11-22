package ro.robertgabriel.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.robertgabriel.entities.TodoList;

@Repository
public interface TodoListRepository extends CrudRepository<TodoList, String>{
}
