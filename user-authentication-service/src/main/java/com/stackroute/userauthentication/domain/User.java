package com.stackroute.userauthentication.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class User implements Serializable {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "cnfpassword")
    private String cnfpassword;
    @Column(name = "active")
    private boolean enabled;
    @Column(name = "role")
    private String role;
    @Column(name = "regdate")
    private LocalDate regdate;

    public User(String firstName, String lastName, String email, String password, String cnfpassword, boolean enabled, String role, LocalDate regdate) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.cnfpassword = cnfpassword;
        this.enabled = enabled;
        this.role = role;
        this.regdate = regdate;
    }

    public User(String id, String firstName, String lastName, String email, String password, String cnfpassword, boolean enabled, String role, LocalDate regdate) {
//       this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.cnfpassword = cnfpassword;
        this.enabled = enabled;
        this.role = role;
        this.regdate = regdate;
    }


    public User() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCnfpassword() {
        return cnfpassword;
    }

    public void setCnfpassword(String cnfpassword) {
        this.cnfpassword = cnfpassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setActive(boolean active) {
        this.enabled = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getRegdate() {
        return regdate;
    }

    public void setRegdate(LocalDate regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cnfpassword='" + cnfpassword + '\'' +
                ", enabled=" + enabled +
                ", role='" + role + '\'' +
                ", regdate=" + regdate +
                '}';
    }
}


