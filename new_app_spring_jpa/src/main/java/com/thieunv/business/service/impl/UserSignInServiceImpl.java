package com.thieunv.business.service.impl;

import com.thieunv.business.service.UserSignInService;
import com.thieunv.data.model.Role;
import com.thieunv.data.model.UserSignIn;
import com.thieunv.data.repository.RoleRepository;
import com.thieunv.data.repository.UserSignInRepository;
import com.thieunv.helper.Constant;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;

/**
 * Created by thieunv on 05/06/2017.
 */
@Service
public class UserSignInServiceImpl implements UserSignInService {

    private final UserSignInRepository userSignInRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MessageSource messageSource;

    private Locale locale = LocaleContextHolder.getLocale();

    @Autowired
    public UserSignInServiceImpl(MessageSource messageSource, UserSignInRepository userSignInRepository,
                                 RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.messageSource = messageSource;
        this.userSignInRepository = userSignInRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }



    @Override
    public UserSignIn findUserByEmail(String email) {
        return userSignInRepository.findByEmail(email);
    }


    @Override
    public UserSignIn saveUserSignIn(UserSignIn userSignIn) {
        userSignIn.setPassword(bCryptPasswordEncoder.encode(userSignIn.getPassword()));
        userSignIn.setStatusFlag(Constant.User.USER_ACTIVATED);
        Role role = roleRepository.findByRole(Constant.Role.ROLE_SUBSCRIBER);
        userSignIn.setRoles(new HashSet<Role>(Collections.singletonList(role)));
        return userSignInRepository.saveAndFlush(userSignIn);
    }
}
