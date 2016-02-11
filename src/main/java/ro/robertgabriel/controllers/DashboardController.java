package ro.robertgabriel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ro.robertgabriel.services.DashboardService;

import javax.inject.Inject;

@Controller
public class DashboardController extends BaseController {

    @Inject
    private DashboardService dashboardService;

    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public ModelAndView getDashboard() {
        ModelAndView modelAndView = new ModelAndView("dashboardPage");
        modelAndView.addObject("user", getAuthenticatedUser());
        modelAndView.addObject("dashboardContent", dashboardService.getDashboardContent());
        return modelAndView;
    }

}
