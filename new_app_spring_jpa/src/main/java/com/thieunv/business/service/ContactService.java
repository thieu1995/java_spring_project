package com.thieunv.business.service;

import com.thieunv.data.model.Contact;

import java.util.List;

/**
 * Created by thieunv on 05/06/2017.
 */
public interface ContactService {
    Contact save(Contact contact);

    List<Contact> getContacts();
}
