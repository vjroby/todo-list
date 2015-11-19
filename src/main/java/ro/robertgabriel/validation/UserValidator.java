package ro.robertgabriel.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ro.robertgabriel.entities.User;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(final Object o, final Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "message.firstName", "Firstname is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "message.lastName", "Last name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "message.password", "Password is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "message.username", "Email is required");
    }
}
