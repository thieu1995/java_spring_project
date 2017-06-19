package com.thieunv.business.service.impl;

import com.thieunv.data.repository.UserSignInRepository;
import com.thieunv.data.model.Role;
import com.thieunv.data.model.UserSignIn;
import com.thieunv.helper.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by thieunv on 20/06/2017.
 */
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final UserSignInRepository userSignInRepository;

    @Autowired
    public CustomUserDetailsServiceImpl(UserSignInRepository userSignInRepository) {
        this.userSignInRepository = userSignInRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserSignIn user = userSignInRepository.findByEmail(userName);
        if (user == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        boolean status = user.getStatusFlag() == Constant.User.USER_ACTIVATED;

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(),status,
                true, true, true, grantedAuthorities);

    }
}