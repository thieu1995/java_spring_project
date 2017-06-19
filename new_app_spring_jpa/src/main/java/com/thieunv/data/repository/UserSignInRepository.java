package com.thieunv.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thieunv.data.model.UserSignIn;

/**
 * Created by thieunv on 05/06/2017.
 */

public interface UserSignInRepository extends JpaRepository<UserSignIn, Long> {
    UserSignIn findByEmail(String email);
    UserSignIn findByUserName(String userName);
}