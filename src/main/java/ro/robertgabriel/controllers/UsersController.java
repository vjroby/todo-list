package ro.robertgabriel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ro.robertgabriel.services.UserDetailsService;

@Controller
@RequestMapping(value = "/users")
public class UsersController extends BaseController {

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = {"view/{userId}"}, method = RequestMethod.GET)
    public ModelAndView viewUser(
            @PathVariable("userId") String userId
    ) {
        log.info("View user.");
        ModelAndView modelAndView = new ModelAndView("userCreatePage");
        modelAndView.addObject("user", getAuthenticatedUser());
        return modelAndView;
    }

    @RequestMapping(value = {"view/{userId}"}, method = RequestMethod.POST)
    public ModelAndView updateUser(){
        ModelAndView modelAndView = new ModelAndView("userCreatePage");
        modelAndView.addObject("user", getAuthenticatedUser());
        return modelAndView;
    }
}
