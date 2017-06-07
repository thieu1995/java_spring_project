package com.thieunv.data.repository;

import com.thieunv.data.model.Contact;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by thieunv on 05/06/2017.
 */
public interface ContactRepository extends CrudRepository<Contact, Serializable> {
    Contact save(Contact contact);

    List<Contact> findAll();

    Contact findContactByEmail(String email);
}
