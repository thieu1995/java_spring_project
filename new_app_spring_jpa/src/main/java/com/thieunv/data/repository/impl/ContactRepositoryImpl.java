package com.thieunv.data.repository.impl;

import com.thieunv.data.model.Contact;
import com.thieunv.data.repository.ContactRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by thieunv on 05/06/2017.
 */
@Repository
public class ContactRepositoryImpl implements ContactRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Contact save(Contact contact) {
        entityManager.persist(contact);
        entityManager.flush();      // It's not saved to real database util we say it flush.
        return contact;
    }
}
