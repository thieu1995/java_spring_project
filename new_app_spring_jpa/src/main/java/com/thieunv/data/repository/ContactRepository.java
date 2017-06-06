package com.thieunv.data.repository;

import com.thieunv.data.model.Contact;

import java.util.List;

/**
 * Created by thieunv on 05/06/2017.
 */
public interface ContactRepository {
    Contact save(Contact contact);

    List<Contact> find();
}
