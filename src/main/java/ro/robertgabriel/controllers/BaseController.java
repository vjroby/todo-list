package ro.robertgabriel.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import ro.robertgabriel.security.SecurityUtils;

public class BaseController {

    protected static final Logger log = LogManager.getLogger();

    @InitBinder     /* Converts empty strings into null when a form is submitted */
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    protected User getAuthenticatedUser() {
        return SecurityUtils.getActiveAuthenticatedUser();
    }
}
