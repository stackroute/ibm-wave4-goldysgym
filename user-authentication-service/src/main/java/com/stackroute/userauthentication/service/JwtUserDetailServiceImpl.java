package com.stackroute.userauthentication.service;

import com.stackroute.userauthentication.filter.JwtUserFactory;
import com.stackroute.userauthentication.domain.User;
import com.stackroute.userauthentication.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public JwtUserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmailIgnoreCase(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No User found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }

    }
}
