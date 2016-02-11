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
import java.util.Date;

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
        TodoList todoListFromDB = null == todoList.getId() ? null : todoListRepository.findOne(todoList.getId());
        if(null != todoListFromDB){
            todoListFromDB.setDescription(todoList.getDescription());
            todoListFromDB.setTitle(todoList.getTitle());
            todoListFromDB.setUpdated(new Date());
            todoList = todoListFromDB;
        }

        todoListRepository.save(todoList);
    }

    @Override
    public TodoList findOne(String listId) throws EntityNotFoundException {
        TodoList todoList =  todoListRepository.findOne(listId);
        throwExceptionIfNUll(todoList);
        return todoList;
    }

    @Override
    public TodoList findOneByIdAndUserId(String id, String userId) {
        TodoList todoList =  todoListRepository.findOneByIdAndUserId(id, userId);
        throwExceptionIfNUll(todoList);
        todoList.setItems(itemRepository.findByListId(todoList.getId()));
        return todoList;
    }

    private void throwExceptionIfNUll(TodoList todoList){
        if (todoList == null){
            throw new EntityNotFoundException();
        }
    }
}
