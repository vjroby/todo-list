package ro.robertgabriel.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SecurityUtils {

    /**
     * Get the active authentication object.
     * @param strict Whether to throw an exception if no authentication object is found.
     * @return Authentication object. Can be null only in non-strict mode.
     */
    public static Authentication getAuthentication(boolean strict) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (strict && authentication == null) {
            throw new AuthenticationCredentialsNotFoundException("Missing authentication object");
        }
        return authentication;
    }

    public static User getActiveAuthenticatedUser() {
        Object user = getAuthentication(true).getPrincipal();
        if(!(user instanceof User)) {
            throw new AccessDeniedException("Invalid user '"+ user+ "'.");
        }
        return (User) user;
    }
}
