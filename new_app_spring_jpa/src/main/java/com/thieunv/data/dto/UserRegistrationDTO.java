package com.thieunv.data.dto;

import com.thieunv.helper.Constant;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by thieunv on 05/06/2017.
 */

public class UserRegistrationDTO {


    @NotEmpty
    private String fullName;

    @NotEmpty
    private String userName;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String matchingPassword;

    @NotNull
    private short gender;

    private Map<Short, String> mapGender;
    public Map<Short, String> getMapGender() {
        return mapGender;
    }
    private void initGender() {
        mapGender = new HashMap<Short, String>();
        mapGender.put(Constant.CommonVar.USER_GENDER_MAN, "Man");
        mapGender.put(Constant.CommonVar.USER_GENDER_WOMAN, "Woman");
        this.setGender(Constant.CommonVar.USER_GENDER_MAN);
    }

    public UserRegistrationDTO() {
        initGender();
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public short getGender() {
        return gender;
    }

    public void setGender(short gender) {
        this.gender = gender;
    }
}
