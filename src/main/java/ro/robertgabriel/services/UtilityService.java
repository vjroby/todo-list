package ro.robertgabriel.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ro.robertgabriel.entities.Config;
import ro.robertgabriel.entities.TodoList;
import ro.robertgabriel.repositories.ConfigRepository;
import ro.robertgabriel.repositories.ItemRepository;
import ro.robertgabriel.repositories.TodoListRepository;
import ro.robertgabriel.repositories.UserRepository;

@Component
public class UtilityService {

    private static final Logger log = LogManager.getLogger();
    private static final String testUserKey="testUserId";

    @Autowired
    ConfigRepository configRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TodoListRepository todoListRepository;

    @Autowired
    ItemRepository itemRepository;

    private String userId = null;


    @Scheduled(cron = "* * 1 * * *")
    public void deleteTestUserData(){
        Iterable<TodoList> todoListLists = todoListRepository.findByUserId(getTestUserId());

        for (TodoList todoList:
                todoListLists
             ) {
            itemRepository.deleteByListId(todoList.getId());
        }
//        todoListLists.forEach(list ->{
//            itemRepository.deleteByListId(list.getId());
//        });
        todoListRepository.delete(todoListLists);
        log.info("Method ran!"+ System.currentTimeMillis());
    }

    public String getTestUserId(){
        if(null == userId){
            Config config = configRepository.findOneByKey(testUserKey);
            if(null == config){
                log.error("user id not found in config");
                return null;
            }
            userId = config.getValue();
        }
        return userId;
    }
}
