package ro.robertgabriel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.robertgabriel.entities.User;
import ro.robertgabriel.exceptions.EmailExistsException;
import ro.robertgabriel.repositories.UserRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        String password = "password";
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String hashedPassword = passwordEncoder.encode(password);
        System.out.println("Getting access details from employee dao !!");
        List<User> userList = userRepository.findByEmail(email);
        if (userList.size() != 0){
            List<GrantedAuthority> auth = AuthorityUtils
                    .commaSeparatedStringToAuthorityList("ROLE_USER");
            User user = userList.get(0);
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                    true, true, true, true, auth);
        }else{
            throw  new UsernameNotFoundException("User not found");
        }
    }

    public static List<GrantedAuthority> getGrantedAuthorities(
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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        user.setCreated(new Date());
        return userRepository.save(user);
    }


    private boolean emailExist(String email) {
        List<User> userList = userRepository.findByEmail(email);
        return userList.size() != 0;
    }
}
