package com.thieunv.presentation.controller;

import com.thieunv.business.service.ContactService;
import com.thieunv.data.dto.ContactDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by thieunv on 04/06/2017.
 */
@Controller
@RequestMapping("contact")
public class ContactController {

    private static final String VIEW_LIST_CONTACT_PAGE = "contact/contact_list";
    private static final String VIEW_CONTACT_FORM_PAGE  = "contact/contact_form";

    private final ContactService contactService;
    private final MessageSource messageSource;
    @Autowired
    public ContactController(MessageSource messageSource, ContactService contactService) {
        this.messageSource = messageSource;
        this.contactService = contactService;
    }


    @RequestMapping(value="/", method = RequestMethod.GET)
    public String viewListContactPage(Model model, Locale locale) {
        model.addAttribute("title", messageSource.getMessage("index.title", null, locale));
        model.addAttribute("greeting", messageSource.getMessage("index.greeting", null, locale));
        return VIEW_LIST_CONTACT_PAGE;
    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String viewFromCreateNewContact(Model model, Locale locale) {
        model.addAttribute("title", messageSource.getMessage("index.title", null, locale));
        model.addAttribute("greeting", messageSource.getMessage("index.greeting", null, locale));
        return VIEW_CONTACT_FORM_PAGE;
    }

    @RequestMapping(value="/add/save", method = RequestMethod.POST)
    public String processFromCreateNewContact(@Valid @ModelAttribute ContactDTO contactDTO, BindingResult result, Locale locale) {
        if(result.hasErrors()) {
            return VIEW_CONTACT_FORM_PAGE;
        }
        this.contactService.save(contactDTO.transferToContact());
        return VIEW_LIST_CONTACT_PAGE;
    }

}
