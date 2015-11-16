package ro.robertgabriel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.robertgabriel.entities.User;
import ro.robertgabriel.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;


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
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                    true, true, true, true, auth);
            return userDetails;
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
}
