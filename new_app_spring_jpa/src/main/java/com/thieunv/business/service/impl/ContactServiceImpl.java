package com.thieunv.business.service.impl;

import com.thieunv.business.service.ContactService;
import com.thieunv.business.service.entity.ServiceResult;
import com.thieunv.data.model.Contact;
import com.thieunv.data.repository.ContactRepository;
import com.thieunv.helper.MessageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

/**
 * Created by thieunv on 05/06/2017.
 */
@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final MessageSource messageSource;
    private Locale locale = LocaleContextHolder.getLocale();

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository, MessageSource messageSource) {
        this.contactRepository = contactRepository;
        this.messageSource = messageSource;
    }

    @Override
    @Transactional  // Tell spring this is Transaction to it auto config error if happen
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @Override
    public ServiceResult<Contact> getContactByEmail(String email) {
        if (email == null) {
            return new ServiceResult<Contact>(null, false,
                    messageSource.getMessage(MessageConstant.Error.MESSAGE_EMAIL_NONE, null, locale));
        }
        Contact contact = contactRepository.findContactByEmail(email);
        return setContactData(contact);
    }

    @Override
    public ServiceResult<Contact> findOneById(int id) {
        Contact contact = contactRepository.findByContactId(id);
        return setContactData(contact);
    }

    @Override
    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }

    private ServiceResult<Contact> setContactData(Contact contact) {
        ServiceResult<Contact> serviceResult = new ServiceResult<Contact>();
        serviceResult.setData(contact);
        serviceResult.setSuccessful(true);
        return serviceResult;
    }
}
