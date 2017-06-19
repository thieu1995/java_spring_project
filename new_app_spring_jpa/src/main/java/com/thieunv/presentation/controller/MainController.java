package com.thieunv.presentation.controller;

import com.thieunv.business.service.UserSignInService;
import com.thieunv.data.dto.UserRegistrationDTO;
import com.thieunv.data.model.UserSignIn;
import com.thieunv.helper.Constant;
import com.thieunv.helper.MessageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by thieunv on 04/06/2017.
 */
@Controller
public class MainController {

    private UserSignInService userSignInService;
    private MessageSource messageSource;
    @Autowired
    public MainController(UserSignInService userSignInService, MessageSource messageSource) {
        this.userSignInService = userSignInService;
        this.messageSource = messageSource;
    }

    @GetMapping({"/", "home"})
    public String getIndex() {
        return Constant.MainController.VIEW_INDEX_PAGE;
    }

    @GetMapping("/login")
    public String getLogin() {
        return Constant.MainController.VIEW_SIGN_IN_PAGE;
    }

    @GetMapping("/login/failed")
    public String getLoginFailed(RedirectAttributes redirect, Locale locale, Model model) {
        redirect.addFlashAttribute(MessageConstant.Error.MESSAGE_ERROR,
                messageSource.getMessage(MessageConstant.Error.MESSAGE_SIGNIN_FAILED,null, locale));
        model.addAttribute(MessageConstant.Error.MESSAGE_ERROR,
                messageSource.getMessage(MessageConstant.Error.MESSAGE_SIGNIN_FAILED,null, locale));
        return Constant.MainController.REDIRECT_SIGN_IN_PAGE;
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return Constant.MainController.REDIRECT_SIGN_IN_PAGE;
    }

    @RequestMapping({"/registration", "/signup"})
    public String getRegistrationPage(Model model) {
        model.addAttribute("userRegistrationDTO", new UserRegistrationDTO());
        return Constant.MainController.VIEW_SIGN_UP_PAGE;
    }

    @RequestMapping(value = "/registration/save", method = RequestMethod.POST)
    public String saveUser(@Valid UserRegistrationDTO userRegistrationDTO, BindingResult result,
                           RedirectAttributes redirect, Locale locale) {
        if (result.hasErrors()) {
            redirect.addFlashAttribute(MessageConstant.Error.MESSAGE_ERROR,
                    messageSource.getMessage(MessageConstant.Error.MESSAGE_SIGNUP_FAILED,null, locale));
            return Constant.MainController.REDIRECT_SIGN_UP_PAGE;
        }
        userSignInService.saveUserSignIn(userRegistrationDTO.transferToUserSignIn());
        redirect.addFlashAttribute(MessageConstant.Success.MESSAGE_SUCCESS,
                messageSource.getMessage(MessageConstant.Success.MESSAGE_SIGNUP_FAILED,null, locale));
        return Constant.MainController.REDIRECT_SIGN_IN_PAGE;
    }



   /* @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserSignIn userSignIn = userSignInService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + userSignIn.getUserName() + " (" + userSignIn.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName(Constant.MainController.VIEW_DASHBOARD_PAGE);
        return modelAndView;
    }*/
}


