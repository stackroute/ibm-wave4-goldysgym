package com.stackroute.springbootneo4jCRUD.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.neo4j.ogm.annotation.*;


import java.util.List;

@NodeEntity(label = "User")
//@Data
//@NoArgsConstructorspring-boot-neo4j-CRUD
//@AllArgsConstructor

public class User {

    @Id
    private Long id;
    private String name;
    private int age;
    private Session session;
    private User user;


    @Relationship(type = "likes")
    private List<Session> sessions;

    @JsonIgnore
    @Relationship(type = "follows")
    private List<User> users;
    private UserDetails userDetails;

    public User() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User(Long id, String name, int age, List<Session> sessions, List<User> users) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sessions = sessions;
        this.users = users;
    }
}
