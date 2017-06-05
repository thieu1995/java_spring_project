package com.thieunv.data.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "user_bookmark")
@NamedQuery(name="UserBookmark.findAll", query = "SELECT u FROM UserBookmark u")
public class UserBookmark implements Serializable {


    @Id
    @Column(name = "user_bookmark_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userBookmarkId;

    //bi-directional many-to-one association to UserLogin
    @ManyToOne
    @JoinColumn(name="user_id")
    private UserSignIn userSignIn;

    @OneToMany(mappedBy = "userBookmark", cascade = CascadeType.ALL)
    private List<Bookmark> bookmarks = new ArrayList<Bookmark>();


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthday")
    private Date updatedAt;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "created_at")
    private Date createdAt;


    public int getUserBookmarkId() {
        return userBookmarkId;
    }

    public void setUserBookmarkId(int userBookmarkId) {
        this.userBookmarkId = userBookmarkId;
    }

    public UserSignIn getUserSignIn() {
        return userSignIn;
    }

    public void setUserSignIn(UserSignIn userSignIn) {
        this.userSignIn = userSignIn;
    }

    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
