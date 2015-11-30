package ro.robertgabriel.repositories;

import org.springframework.stereotype.Repository;
import ro.robertgabriel.entities.TodoList;

@Repository
public interface TodoListRepository extends MyBaseRepository<TodoList, String> {

    Iterable<TodoList> findByUserId(String userId);

    TodoList findOneByIdAndUserId(String id, String userId);
}
