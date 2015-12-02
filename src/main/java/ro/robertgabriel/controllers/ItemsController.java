package ro.robertgabriel.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ro.robertgabriel.entities.Item;
import ro.robertgabriel.exceptions.EntityNotFoundException;
import ro.robertgabriel.security.AuthenticatedUser;
import ro.robertgabriel.services.ItemsService;
import ro.robertgabriel.services.TodoListService;

import javax.inject.Inject;

@RequestMapping(value = {"/todos/{listId}/items"})
public class ItemsController extends BaseController {

    private static final Logger log = LogManager.getLogger();

    @Inject
    private ItemsService itemsService;

    @Inject
    private TodoListService todoListService;

    @RequestMapping(value = {"create"}, method = RequestMethod.GET)
    public ModelAndView createForm(
            @PathVariable("listId") String listId
    ){
        log.info("Inside item create");
        AuthenticatedUser user = getAuthenticatedUser();
        try {
            ModelAndView modelAndView = new ModelAndView("itemCreatePage");
            modelAndView.addObject("user", user);
            modelAndView.addObject("item", new Item());
            modelAndView.addObject("todolist", todoListService.findOne(listId));
            return modelAndView;
        }catch (EntityNotFoundException e){
            return getModelAndViewNotFound(user, "notFoundPage");
        }

    }


}
