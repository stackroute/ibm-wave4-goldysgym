package com.stackroute.jwt.jwtfirst.service;


import com.stackroute.jwt.jwtfirst.model.User;
import com.stackroute.jwt.jwtfirst.repo.UserRepository;
import com.stackroute.jwt.jwtfirst.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {

        String password = PasswordUtil.getPasswordHash(user.getPassword());
        user.setPassword(password);
        user.setDate(new Date());
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
            return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmailIgnoreCase(email);
    }
}
