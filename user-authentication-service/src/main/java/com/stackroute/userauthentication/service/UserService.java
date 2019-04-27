package com.stackroute.userauthentication.service;

import com.stackroute.userauthentication.domain.User;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> findAll();

    User getUserByEmail(String email);
}
