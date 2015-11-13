package ro.robertgabriel.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication()
                .withUser("Robert")
                .password("password")
                .authorities("USER")
                .and()
                .withUser("Gabriel")
                .password("gabi")
                .authorities("USER", "ADMIN");
    }

    @Override
    public void configure(WebSecurity security) throws Exception {
        security.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security
                .authorizeRequests()
                    .antMatchers("/signup","/").permitAll()
                    .anyRequest().authenticated()
                .and().formLogin()
                    .loginPage("/login").failureUrl("/login?error")
                    .defaultSuccessUrl("/secure")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .permitAll()
                .and().logout()
                    .logoutUrl("/logout").logoutSuccessUrl("/login?loggedUut")
                    .invalidateHttpSession(true).deleteCookies("JESSIONID")
                    .permitAll()
//                .and().sessionManagement()
//                    .sessionFixation().changeSessionId()
                .and().csrf().disable();

    }
}
