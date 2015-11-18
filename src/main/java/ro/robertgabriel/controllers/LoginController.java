package ro.robertgabriel.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ro.robertgabriel.entities.User;
import ro.robertgabriel.exceptions.EmailExistsException;
import ro.robertgabriel.services.UserDetailsService;

@Controller
public class LoginController {

    @Autowired
    private UserDetailsService userDetailsService;

    private static final Logger log = LogManager.getLogger();

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
                                  @RequestParam(value = "logout", required = false) String logout) {


        ModelAndView model = new ModelAndView("loginPage");

        if (error != null) {
            model.addObject("error", "Invalid Credentials provided.");
        }

        if (logout != null) {
            model.addObject("message", "Logged out!");
        }

        return model;
    }

    @RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
    public ModelAndView sigupPage(WebRequest request, Model model){
        User user = new User();
        model.addAttribute("user", user);
        return new ModelAndView("signupPage");
    }

    @RequestMapping(value = {"/signup"}, method = RequestMethod.POST)
    public ModelAndView createUserAccount(
            @ModelAttribute @Validated User user,
            BindingResult result, WebRequest request, Errors errors){
        log.debug("Registration started");

        User registered = new User();

        if (!result.hasErrors()) {
            registered = createUserAccount(user, result);
            log.debug("Created user account");
        }

        if (registered == null) {
            result.rejectValue("email", "message.regError");
            log.debug("Registered is null");
        }

        if (result.hasErrors()) {
            log.debug("Result has errors");
            return new ModelAndView("signupPage", "user", user);
        }
        log.debug("Sending user to account created");
        return new ModelAndView("/accountCreatedPage");
    }

    private User createUserAccount(User user, BindingResult result){
        User registered = null;

        try{
            registered = userDetailsService.registerNewUserAccount(user);
        }catch (EmailExistsException e){
            return null;
        }
        return registered;
    }


    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public ModelAndView welcomePage(){
        return new ModelAndView("welcomePage");
    }
}
