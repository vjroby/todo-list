package ro.robertgabriel.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;
import ro.robertgabriel.security.AuthenticatedUser;
import ro.robertgabriel.security.SecurityUtils;

public class BaseController {

    protected static final Logger log = LogManager.getLogger();
    protected final int itemsPerPage = 20;

    @InitBinder     /* Converts empty strings into null when a form is submitted */
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    protected AuthenticatedUser getAuthenticatedUser() {
        return  (AuthenticatedUser) SecurityUtils.getActiveAuthenticatedUser();
    }

    protected ModelAndView getModelAndViewNotFound(AuthenticatedUser user, String notFoundPage) {
        ModelAndView modelAndView = new ModelAndView(notFoundPage);
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
