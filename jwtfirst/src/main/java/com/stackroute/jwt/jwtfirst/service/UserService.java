package com.stackroute.jwt.jwtfirst.service;

import com.stackroute.jwt.jwtfirst.domain.User;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> findAll();

    User getUserByEmail(String email);
}
