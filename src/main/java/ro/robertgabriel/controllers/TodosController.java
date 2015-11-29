package ro.robertgabriel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ro.robertgabriel.entities.TodoList;
import ro.robertgabriel.repositories.TodoListRepository;
import ro.robertgabriel.security.AuthenticatedUser;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping(value = "/todos")
public class TodosController extends BaseController {

    @Autowired
    private TodoListRepository todoListRepository;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public ModelAndView getAllTodos() {
        Iterable<TodoList> todoLists = todoListRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("todosPage");
        modelAndView.addObject("user", getAuthenticatedUser());
        modelAndView.addObject("todolists", todoLists);
        return  modelAndView;
    }

    @RequestMapping(value = {"create"}, method = RequestMethod.GET)
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("todosCreatePage");
        modelAndView.addObject("user", getAuthenticatedUser());
        modelAndView.addObject("todolist", new TodoList());
        return  modelAndView;
    }

    @RequestMapping(value = {"create"}, method = RequestMethod.POST)
    public ModelAndView createTodoList(
            @ModelAttribute("todolist") @Valid TodoList todoList,
            BindingResult result, WebRequest request, Errors errors
    ){

        if(result.hasErrors()){
            return new ModelAndView("todosCreatePage");
        }
        AuthenticatedUser user = getAuthenticatedUser();
        todoList.setUserId(user.getId());
        todoList.setCreated(new Date());
        todoListRepository.save(todoList);

        return new ModelAndView("redirect:/todos/view/" + todoList.getId());
    }

    @RequestMapping(value = {"view/{discussionId}"}, method = RequestMethod.GET)
    public ModelAndView viewTodoList(
            @PathVariable("discussionId") String listId) {
        TodoList todoListIterable = todoListRepository.findOne(listId);
        ModelAndView modelAndView = new ModelAndView("todosCreatePage");
        modelAndView.addObject("user", getAuthenticatedUser());
        modelAndView.addObject("todolist", todoListIterable);
        return modelAndView;
    }

    @RequestMapping(value = {"view/{discussionId}"}, method = RequestMethod.POST)
    public ModelAndView updateTodoList(
            @ModelAttribute("todolist") @Valid TodoList todoList) {
        TodoList todoListIterable = todoListRepository.save(todoList);
        ModelAndView modelAndView = new ModelAndView("redirect:/todos/view/" + todoList.getId());
        modelAndView.addObject("user", getAuthenticatedUser());
        return  modelAndView;
    }
}
