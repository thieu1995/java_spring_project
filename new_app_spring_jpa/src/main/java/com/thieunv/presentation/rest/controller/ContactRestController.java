package com.thieunv.presentation.rest.controller;

import com.thieunv.business.service.ContactService;
import com.thieunv.business.service.entity.ServiceResult;
import com.thieunv.data.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * Created by thieunv on 07/06/2017.
 */
@RestController
@RequestMapping("/rest/contact")
public class ContactRestController {

    private final ContactService contactService;

    @Autowired
    public ContactRestController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value="/check_email_existed", method = RequestMethod.GET)
    public boolean checkEmailNotExisted(@RequestParam String email, Locale locale, Model model) {
        ServiceResult<Contact> serviceResult = contactService.checkEmail(email);
        if(serviceResult.isSuccessful()) {
            Contact contact = serviceResult.getData();
            if(contact == null) {
                return true;
            }
        }
        return false;
    }
}
