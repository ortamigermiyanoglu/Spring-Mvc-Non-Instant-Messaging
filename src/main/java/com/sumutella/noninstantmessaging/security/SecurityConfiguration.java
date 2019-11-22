package com.sumutella.noninstantmessaging.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * @author sumutella
 * @time 10:14 AM
 * @since 11/14/2019, Thu
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSourceLogin;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSourceLogin);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/home/**").hasRole("scenarist")
                .and()
                .formLogin()
                .loginPage("/my-login")
                .loginProcessingUrl("/auth-user")
                .defaultSuccessUrl("/home")
                .permitAll()
            .and()
                .logout()
                .logoutSuccessUrl("/my-login?logout").invalidateHttpSession(true)
                .deleteCookies("JSESSIONID").permitAll(); // after logout then redirect to login page;


    }



}
