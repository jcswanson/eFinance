package com.ist412.efinance.model;

import lombok.*;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long uid;
    @Column(name = "first", nullable = false, length = 45)
    private String firstName;
    @Column(name = "last", nullable = false, length = 45)
    private String lastName;
    @Column(name = "email", unique = true, length = 45)
    private String emailAddress;
    @Column(name = "phone_num")
    private String phoneNumber;
    @Column(name = "dob")
    private String dateOfBirth;
    @Column(name = "address")
    private String address;
    @Column(name = "state")
    private String state;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "username", unique = true, nullable = false, length = 45)
    private String username;
    @Column(name = "password", nullable = false, length = 45)
    private String password;
    @Column(name = "role", length = 25)
    private String role = "ROLE_USER";
    @Column(name = "enabled")
    private boolean enabled = true;

}
