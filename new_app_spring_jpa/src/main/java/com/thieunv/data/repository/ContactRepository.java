package com.thieunv.data.repository;

import com.thieunv.data.model.Contact;

/**
 * Created by thieunv on 05/06/2017.
 */
public interface ContactRepository {
    Contact save(Contact contact);
}
