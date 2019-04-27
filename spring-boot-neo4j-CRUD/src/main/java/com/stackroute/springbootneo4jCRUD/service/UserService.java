package com.stackroute.springbootneo4jCRUD.service;


import com.stackroute.springbootneo4jCRUD.domain.Program;
import com.stackroute.springbootneo4jCRUD.domain.Session;
import com.stackroute.springbootneo4jCRUD.domain.User;
import com.stackroute.springbootneo4jCRUD.domain.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User saveUser(UserDetails userDetails);
    public Iterable<User> getAllUsers();
    public Session saveSession(Session session);
    Iterable<Session> getAll();
    void deleteData();

    Iterable<Session> getAllSessions();

    Iterable<User> followUsers(String name);

    Iterable<Session> recommend(String name);


    Iterable<User> recommendUser(String name);

    void saveRelationLikes(String username, String sessionname);

    Iterable<User> agegroup(String name);

    void saveRelation(String name1, String name2);

    void unfollow(String name1, String name2);

    Iterable<User> userfollow(String name);
}
