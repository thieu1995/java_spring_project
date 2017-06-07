package com.thieunv.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
        http.sessionManagement().maximumSessions(1).expiredUrl("/error");
        http.csrf() // ignore our stomp endpoints since they are protected using
                // Stomp headers
                .ignoringAntMatchers("/app/**").and().headers()
                // allow same origin to frame our site to support iframe SockJS
                .frameOptions().sameOrigin().and().authorizeRequests()
                .antMatchers("/resources/**", "/css/**", "/js/**", "/img/**", "/password-reminder/**", "/register/**",
                        "/answer", "/security-policy", "/role-use", "/error","/rest/**").permitAll();
    }
}