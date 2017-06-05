package com.thieunv.data.dto;

import com.thieunv.data.model.Contact;

/**
 * Created by thieunv on 05/06/2017.
 */
public class ContactDTO {
    private Long id;
    private String email;
    private String fullName;
    private String phoneNumber;

    public ContactDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Contact transferToContact() {
        Contact contact = new Contact();
        contact.setEmail(this.email);
        contact.setFullName(this.fullName);
        contact.setPhoneNumber(this.phoneNumber);
        return contact;
    }
}
