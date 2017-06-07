package com.thieunv.data.repository.impl;

import com.thieunv.data.model.Contact;
import com.thieunv.data.repository.ContactRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by thieunv on 05/06/2017.
 */
@Repository
public class ContactRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;


    public Contact save(Contact contact) {
        entityManager.persist(contact);
        entityManager.flush();      // It's not saved to real database util we say it flush.
        return contact;
    }


    public List<Contact> find() {
        Query query = entityManager.createQuery("SELECT e FROM Contact e");
        List<Contact> resultList = (List<Contact>) query.getResultList();
        entityManager.flush();
        return resultList;
    }

    public Contact findContactByEmail(String email) {
        return null;
    }
}
