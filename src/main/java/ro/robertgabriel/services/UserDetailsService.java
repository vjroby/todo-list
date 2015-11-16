package ro.robertgabriel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.robertgabriel.entities.User;
import ro.robertgabriel.repositories.UserRepository;

import java.util.List;

@Service("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("Getting access details from employee dao !!");
        User user = (User)userRepository.findByEmail(s);
        if (user != null){
            List<GrantedAuthority> auth = AuthorityUtils
                    .commaSeparatedStringToAuthorityList("ROLE_USER");

            UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
                    true, true, true, true, auth);
            return userDetails;
        }else{
            throw  new UsernameNotFoundException("User not found");
        }
    }
}
