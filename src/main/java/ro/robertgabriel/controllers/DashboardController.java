package ro.robertgabriel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController extends BaseController {

    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public ModelAndView getDashboard() {
        return new ModelAndView("dashboardPage");
    }

}
