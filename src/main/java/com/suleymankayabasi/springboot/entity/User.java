package com.suleymankayabasi.springboot.entity;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @SequenceGenerator(name = "generator",sequenceName = "USER_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID",nullable = false)
    private Long id;

    @Column(length = 50,name = "NAME")
    private String name;

    @Column(length = 50,name = "LAST_NAME")
    private String lastName;

    @Column(length = 50,name = "EMAIL")
    private String email;

    @Column(length = 15,name = "PHONE_NUMBER",unique = true)
    private String phoneNumber;

    @Column(length = 20,name = "USERS_NAME",unique = true)
    private String userName;

    public User() {
    }

    public User(Long id, String name, String lastName, String email, String phoneNumber, String userName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
