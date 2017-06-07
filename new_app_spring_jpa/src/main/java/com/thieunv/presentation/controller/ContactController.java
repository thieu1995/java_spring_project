package com.thieunv.presentation.controller;

import com.thieunv.business.service.ContactService;
import com.thieunv.business.service.entity.ServiceResult;
import com.thieunv.data.model.Contact;
import com.thieunv.helper.Constant;
import com.thieunv.helper.MessageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by thieunv on 04/06/2017.
 */
@Controller
@RequestMapping("contact")
public class ContactController {

    private final ContactService contactService;
    private final MessageSource messageSource;
    @Autowired
    public ContactController(MessageSource messageSource, ContactService contactService) {
        this.messageSource = messageSource;
        this.contactService = contactService;
    }

    @RequestMapping(value={ "", "/", " "}, method = RequestMethod.GET)
    public String redirectToContactListPage(Model model, Locale locale) {
        return Constant.ContactController.REDIRECT_TO_CONTACT_LIST;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public String viewListContactPage(Model model, Locale locale) {
        model.addAttribute(Constant.ContactController.MODEL_CONTACTS_NAME, contactService.getContacts());
        return Constant.ContactController.VIEW_CONTACT_LIST_PAGE;
    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String viewFromCreateNewContact(Model model, Locale locale) {
        model.addAttribute(Constant.ContactController.MODEL_CONTACT_NAME, new Contact());
        return Constant.ContactController.VIEW_CONTACT_FORM_PAGE;
    }

    @RequestMapping(value="/add/save", method = RequestMethod.POST)
    public String processFromCreateNewContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result, Locale locale) {
        if(result.hasErrors()) {
            return Constant.ContactController.REDIRECT_TO_CONTACT_FORM;
        }
        this.contactService.save(contact);
        return Constant.ContactController.REDIRECT_TO_CONTACT_LIST;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String viewEditContactPage(@PathVariable int id, Model model, RedirectAttributes redirect, Locale locale) {
        ServiceResult<Contact> serviceResult = contactService.findOneById(id);
        if(serviceResult.isSuccessful()) {
            Contact contact = serviceResult.getData();
            if(contact == null) {
                redirect.addFlashAttribute(MessageConstant.Error.MESSAGE_ERROR, messageSource.getMessage(MessageConstant.Error.MESSAGE_CONTACT_NOT_FOUND, null, locale));
                return Constant.ContactController.REDIRECT_TO_CONTACT_LIST;
            }
            model.addAttribute(Constant.ContactController.MODEL_CONTACT_NAME, contact);
            return Constant.ContactController.VIEW_CONTACT_FORM_PAGE;
        }
        return Constant.Common.VIEW_404_PAGE;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String processDeleteContact(@PathVariable int id, Model model, RedirectAttributes redirect, Locale locale) {
        ServiceResult<Contact> serviceResult = contactService.findOneById(id);
        if(serviceResult.isSuccessful()) {
            Contact contact = serviceResult.getData();
            if(contact == null) {
                redirect.addFlashAttribute(MessageConstant.Error.MESSAGE_ERROR, messageSource.getMessage(MessageConstant.Error.MESSAGE_DELETE_CONTACT, null, locale));
                return Constant.ContactController.REDIRECT_TO_CONTACT_LIST;
            }
            contactService.deleteContact(contact);
            redirect.addFlashAttribute(MessageConstant.Success.MESSAGE_SUCCESS, messageSource.getMessage(MessageConstant.Success.MESSAGE_DELETE_CONTACT, null, locale));
            return Constant.ContactController.REDIRECT_TO_CONTACT_LIST;
        }
        return Constant.Common.VIEW_404_PAGE;
    }

    @RequestMapping(value = "/**", method = RequestMethod.GET)
    public String view404Page(Locale locale) {
        return Constant.Common.VIEW_404_PAGE;
    }
}
