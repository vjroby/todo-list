package ro.robertgabriel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ro.robertgabriel.entities.TodoList;
import ro.robertgabriel.repositories.TodoListRepository;

import javax.validation.Valid;

@Controller
public class TodosController extends BaseController {

    @Autowired
    private TodoListRepository todoListRepository;

    @RequestMapping(value = {"/todos"}, method = RequestMethod.GET)
    public ModelAndView getAllTodos() {
        ModelAndView modelAndView = new ModelAndView("todosPage");
        modelAndView.addObject("user", getAuthenticatedUser());
        return  modelAndView;
    }

    @RequestMapping(value = {"/todos/create"}, method = RequestMethod.GET)
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("todosCreatePage");
        modelAndView.addObject("user", getAuthenticatedUser());
        return  modelAndView;
    }

    @RequestMapping(value = {"/todos/create"}, method = RequestMethod.POST)
    public ModelAndView createTodoList(
            @ModelAttribute("todolist") @Valid TodoList todoList,
            BindingResult result, WebRequest request, Errors errors
    ){
        ModelAndView modelAndView = new ModelAndView("/todo/create");
        todoListRepository.save(todoList);
        return  modelAndView;
    }

}
