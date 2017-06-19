package com.thieunv.config;

import com.thieunv.helper.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by thieunv on 07/06/2017.
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*http.
                authorizeRequests()
                .antMatchers("/webjars*//**").permitAll()
                .antMatchers("/js*//**").permitAll()
                .antMatchers("/css*//**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/contact*//**").permitAll()
                .antMatchers("/admin*//**").hasAuthority(Constant.Role.ROLE_SUBSCRIBER)
                .anyRequest().authenticated()
                .and().csrf().disable()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login/failed")
                .defaultSuccessUrl("/admin/home")
                .usernameParameter("email")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling()
                .accessDeniedPage("/access-denied");*/

        http.csrf() // ignore our stomp endpoints since they are protected using
                // Stomp headers
                .ignoringAntMatchers("/app/**").and().headers()
                // allow same origin to frame our site to support iframe SockJS
                .frameOptions().sameOrigin().and().authorizeRequests()
                .antMatchers("/webjars/**", "/resources/**", "/css/**", "/js/**", "/img/**", "/images/**", "/static/**",
                        "/password-reminder/**", "/registration/**","/contact/**", "/signup",
                        "/login", "/error","/rest/**","/debug/**").permitAll()
                .antMatchers("/admin/**").hasAuthority(Constant.Role.ROLE_SUBSCRIBER)
                .anyRequest()
                .authenticated().and().authorizeRequests().antMatchers("/api/**").authenticated()
                .and().formLogin()
                .loginPage("/login")
                .failureUrl("/login/failed")
                .defaultSuccessUrl("/admin/home")
                .usernameParameter("email")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling()
                .accessDeniedPage("/access-denied");
    }
}