package com.stackroute.jwt.jwtfirst.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private  String email;
    @Column(name = "password")
    private String password;
    @Column(name = "confirmPassword")
    private String cnfpassword;
    @Column(name = "enable")
    private  boolean enabled;
    @Column(name = "role")
    private String role;
    @Column(name = "phoneNumber")
    private String phonenumber;
    @Column(name = "date")
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getCnfpassword() { return cnfpassword; }

    public void setCnfpassword(String cnfpassword) { this.cnfpassword = cnfpassword; }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User(long id, String firstName, String lastName, String email, String password, String cnfpassword,boolean enabled, String role, String phonenumber, Date date) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.cnfpassword = cnfpassword;
        this.enabled = enabled;
        this.role = role;
        this.phonenumber = phonenumber;
        this.date = date;
    }

    public User() {
    }
}
