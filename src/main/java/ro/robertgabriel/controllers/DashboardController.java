package ro.robertgabriel.controllers;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ro.robertgabriel.security.SecurityUtils;

@Controller
public class DashboardController extends BaseController {

    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public ModelAndView getDashboard() {
        ModelAndView modelAndView = new ModelAndView("dashboardPage");
        modelAndView.addObject("user", getAuthenticatedUser());
        return modelAndView;
    }

}
