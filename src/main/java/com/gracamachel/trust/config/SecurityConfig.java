package com.gracamachel.trust.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by thembelani on 7/18/17.
 */
@Configuration
@EnableWebSecurity
//@Import(ServiceConfig.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("root").password("root").roles(new String [] {"ADMIN", "SUPER_USER"});
        //auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/home").access("hasAnyRole('ADMIN','SUPER_USER')")
                .antMatchers("/resources/css/**").permitAll()
                .antMatchers("/subCategory/**").permitAll()
                .antMatchers("/resources/font/**").permitAll()
                .antMatchers("/resources/img/**").permitAll()
                .antMatchers("/resources/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error")
                .permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .and()
                .csrf().disable();
    }



}
