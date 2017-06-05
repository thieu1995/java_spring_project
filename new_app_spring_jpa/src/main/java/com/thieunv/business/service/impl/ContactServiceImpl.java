package com.thieunv.business.service.impl;

import com.thieunv.business.service.ContactService;
import com.thieunv.data.model.Contact;
import com.thieunv.data.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by thieunv on 05/06/2017.
 */
@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    @Transactional  // Tell spring this is Transaction to it auto config error if happen
    public Contact save(Contact contact) {
        return this.contactRepository.save(contact);
    }
}
