package com.thieunv.data.model;

import javax.persistence.*;

/**
 * Created by thieunv on 05/06/2017.
 */
@Entity
@Table(name = "bookmark")
public class Bookmark {

    @Id
    @GeneratedValue
    private Long id;

    private String uri;
    private String description;
    private String category;

    @ManyToOne
    private UserProfile userProfile;


    public Bookmark() {}    // jpa only


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}