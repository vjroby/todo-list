package ro.robertgabriel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.robertgabriel.entities.User;
import ro.robertgabriel.exceptions.EmailExistsException;
import ro.robertgabriel.exceptions.EntityNotFoundException;
import ro.robertgabriel.repositories.UserRepository;
import ro.robertgabriel.security.AuthenticatedUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        System.out.println("Getting access details from employee dao !!");
        List<User> userList = userRepository.findByEmail(email);
        if (userList.size() != 0){
            User user = userList.get(0);
            List<GrantedAuthority> auth = getGrantedAuthorities(user.getRoles());
            AuthenticatedUser authenticatedUser = new AuthenticatedUser(user.getEmail(), user.getPassword(),
                    true, true, true, true, auth);
            authenticatedUser.setFirstName(user.getFirstName());
            authenticatedUser.setLastName(user.getLastName());
            authenticatedUser.setId(user.getId());
            return  authenticatedUser;
        }else{
            throw  new UsernameNotFoundException("User not found");
        }
    }

    private static List<GrantedAuthority> getGrantedAuthorities(
            List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();


        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    public User registerNewUserAccount(User user) throws EmailExistsException {
        if(emailExist(user.getEmail())) {
            throw new EmailExistsException("There is an account with that email adress: "  +
                    user.getEmail());
        }
        if (user.getPassword() != null){

            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        user.setCreated(new Date());
        return userRepository.save(user);
    }

    public User findOne(String userId) throws EntityNotFoundException{
        User user = userRepository.findOne(userId);
        if(null == user){
            throw new EntityNotFoundException();
        }
        return user;
    }

    private boolean emailExist(String email) {
        List<User> userList = userRepository.findByEmail(email);
        return userList.size() != 0;
    }


}
