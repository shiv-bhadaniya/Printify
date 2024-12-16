package com.printify.sgpproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {//this will create a table named user when the spring app. will be run first time after getting connected with mysql
    @Id//this makes id a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//this will automate the value of id
    private Long id;
    private String username;
    private String name;

    public User(String username, String name, String email) {
        super();
        this.username = username;
        this.name = name;
        this.email = email;
    }

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
