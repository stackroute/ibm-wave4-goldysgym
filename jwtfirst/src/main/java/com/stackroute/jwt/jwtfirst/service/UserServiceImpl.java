package com.stackroute.jwt.jwtfirst.service;


import com.stackroute.jwt.jwtfirst.domain.User;
import com.stackroute.jwt.jwtfirst.repo.UserRepository;
import com.stackroute.jwt.jwtfirst.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
   private UserRepository userRepository;

    @Override
    public User save(User user) {
        String password = PasswordUtil.getPasswordHash(user.getPassword());
        user.setPassword(password);
        user.setRegdate( LocalDate.now());
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
