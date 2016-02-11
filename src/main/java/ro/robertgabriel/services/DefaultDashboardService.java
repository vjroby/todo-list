package ro.robertgabriel.services;

import org.springframework.stereotype.Service;
import ro.robertgabriel.entities.Dashboard;
import ro.robertgabriel.repositories.ItemRepository;
import ro.robertgabriel.repositories.TodoListRepository;
import ro.robertgabriel.repositories.UserRepository;

import javax.inject.Inject;

@Service
public class DefaultDashboardService implements DashboardService{

    @Inject
    public ItemRepository itemRepository;
    @Inject
    public TodoListRepository todoListRepository;
    @Inject
    public UserRepository userRepository;

    @Override
    public long countTodoLists() {
        return todoListRepository.count();
    }

    @Override
    public long countItems(){
        return itemRepository.count();
    }

    @Override
    public long countUsers(){
        return userRepository.count();
    }

    @Override
    public Dashboard getDashboardContent(){
        return new Dashboard().setCountItems(countItems())
                .setCountTodoLists(countTodoLists()).setCountUsers(countUsers());
    }
}
