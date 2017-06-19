package com.thieunv.business.service;

import com.thieunv.business.service.entity.ServiceResult;
import com.thieunv.data.model.UserSignIn;

/**
 * Created by thieunv on 05/06/2017.
 */

public interface UserSignInService {
    UserSignIn findUserByEmail(String email);

    UserSignIn saveUserSignIn(UserSignIn userSignIn);

}