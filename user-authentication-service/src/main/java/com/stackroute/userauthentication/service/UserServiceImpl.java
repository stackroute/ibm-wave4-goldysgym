package com.stackroute.userauthentication.service;


import com.stackroute.userauthentication.domain.User;
import com.stackroute.userauthentication.repo.UserRepository;
import com.stackroute.userauthentication.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        String password = PasswordUtil.getPasswordHash(user.getPassword());
        user.setPassword(password);
        user.setRegdate(LocalDate.now());
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmailIgnoreCase(email);
    }
}
