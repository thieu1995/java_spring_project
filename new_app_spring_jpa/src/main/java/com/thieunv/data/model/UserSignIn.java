package com.thieunv.data.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    @Column(name = "birthday")
    private Date updatedAt;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "created_at")
    private Date createdAt;

    //bi-directional many-to-one association to UserCertificate
    @OneToMany(mappedBy="userSignIn")
    private List<UserBookmark> userBookmarks;

}
