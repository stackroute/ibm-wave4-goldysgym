package com.stackroute.enrollment.domain;

import java.time.LocalDate;
import java.util.Date;

public class User {


    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String cnfpassword;
    private boolean enabled;
    private String role;
    private LocalDate regdate;

    public User(String id, String firstName, String lastName, String email, String password, String cnfpassword, boolean enabled, String role,  LocalDate regdate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.cnfpassword = cnfpassword;
        this.enabled = enabled;
        this.role = role;
       // this.phonenumber = phonenumber;
        this.regdate = regdate;
    }

    public User() {
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
//    public String getPhonenumber() {
//        return phonenumber;
//    }
//
//    public void setPhonenumber(String phonenumber) {
//        this.phonenumber = phonenumber;
//    }

    public LocalDate getRegdate() {
        return regdate;
    }

    public void setRegdate(LocalDate regdate) {
        this.regdate = regdate;
    }


}