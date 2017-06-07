package com.thieunv.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by thieunv on 07/06/2017.
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/css/**", "/js/**", "/img/**", "/resources/**")
                .permitAll()
                .antMatchers("/background/**")
                .permitAll()
                .antMatchers("/registrationPage")
                .permitAll()
                .antMatchers("/")
                .permitAll()
                .antMatchers("/rest/**")
                .permitAll()
                .antMatchers("/addRadio")
                .permitAll()
                .antMatchers("/cloth")
                .permitAll();
    }
}