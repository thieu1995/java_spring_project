package com.thieunv.data.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by thieunv on 05/06/2017.
 */
@Entity
@Table(name="user_sign_in")
@NamedQuery(name="UserSignIn.findAll", query="SELECT u FROM UserSignIn u")
public class UserSignIn {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @NotEmpty
    @Column(name="user_name",nullable = false, unique = true)
    private String userName;

    @Email
    @NotEmpty
    @Column(name="email",nullable = false, unique = true)
    private String email;

    @NotEmpty
    @Column(name="password",nullable = false)
    private String password;

    @Column(name="status_flag")
    private short statusFlag;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "updated_at")
    private Date updatedAt;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "created_at")
    private Date createdAt;

    //bi-directional many-to-one association to UserCertificate
    @OneToMany(mappedBy="userSignIn")
    private List<UserBookmark> userBookmarks;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(short statusFlag) {
        this.statusFlag = statusFlag;
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

    public List<UserBookmark> getUserBookmarks() {
        return userBookmarks;
    }

    public void setUserBookmarks(List<UserBookmark> userBookmarks) {
        this.userBookmarks = userBookmarks;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
