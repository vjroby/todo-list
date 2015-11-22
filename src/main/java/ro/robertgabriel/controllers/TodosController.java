package ro.robertgabriel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodosController extends BaseController {

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


}
