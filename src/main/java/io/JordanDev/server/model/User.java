package io.JordanDev.server.model;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@Slf4j
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Uid;

    private String username;
    private String password;
    private String email;
    private final String role = "ROLE_USER";
    private boolean loggedIn;



}
