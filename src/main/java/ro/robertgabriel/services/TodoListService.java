package ro.robertgabriel.services;

import ro.robertgabriel.entities.TodoList;
import ro.robertgabriel.exceptions.EntityNotFoundException;

public interface TodoListService {

    Iterable<TodoList> getAllLists();

    Iterable<TodoList> getListsByUserId(String userId);

    void save(TodoList todoList);

    TodoList findOne(String listId) throws EntityNotFoundException;
    TodoList findOneByIdAndUserId(String id, String userId) throws EntityNotFoundException;
}
