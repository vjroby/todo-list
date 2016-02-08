package ro.robertgabriel.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ro.robertgabriel.entities.TodoList;
import ro.robertgabriel.exceptions.EntityNotFoundException;
import ro.robertgabriel.repositories.ItemRepository;
import ro.robertgabriel.repositories.TodoListRepository;
import ro.robertgabriel.repositories.UserRepository;

import javax.inject.Inject;

@Service
public class DefaultTodoListService implements TodoListService {

    private static final Logger log = LogManager.getLogger();

    @Inject
    TodoListRepository todoListRepository;
    @Inject
    UserRepository userRepository;
    @Inject
    ItemRepository itemRepository;

    @Override
    public Iterable<TodoList> getAllLists() {
        return todoListRepository.findAll();
    }

    @Override
    public Iterable<TodoList> getListsByUserId(String userId) {
        Iterable<TodoList> todoListIterable = todoListRepository.findByUserId(userId);
        for (TodoList todo: todoListIterable
             ) {
            todo.setUser(userRepository.findOne(todo.getUserId()));
        }
        return todoListIterable;
    }

    @Override
    public void save(TodoList todoList) {
        todoListRepository.save(todoList);
    }

    @Override
    public TodoList findOne(String listId) throws EntityNotFoundException {
        TodoList todoList =  todoListRepository.findOne(listId);
        if (todoList == null){
            throw new EntityNotFoundException();
        }
        return todoList;
    }

    @Override
    public TodoList findOneByIdAndUserId(String id, String userId) {
        TodoList todoList =  todoListRepository.findOneByIdAndUserId(id, userId);
        if (todoList == null){
            throw new EntityNotFoundException();
        }
        todoList.setItems(itemRepository.findByListId(todoList.getId()));
        return todoList;
    }
}
