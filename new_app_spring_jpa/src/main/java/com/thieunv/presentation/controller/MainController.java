package com.thieunv.presentation.controller;

import com.thieunv.helper.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

/**
 * Created by thieunv on 04/06/2017.
 */
@Controller
public class MainController {

    private static final String VIEW_INDEX_PAGE = "index";

    private MessageSource messageSource;
    @Autowired
    public MainController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @RequestMapping(value="/", method = RequestMethod.GET)
    public String viewIndexPage(Model model, Locale locale) {
        model.addAttribute("title", messageSource.getMessage("index.title", null, locale));
        model.addAttribute("greeting", messageSource.getMessage("index.greeting", null, locale));
        return VIEW_INDEX_PAGE;
    }
}


