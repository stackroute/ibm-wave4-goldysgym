package com.stackroute.userauthentication.controller;


import com.stackroute.userauthentication.domain.User;
import com.stackroute.userauthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value="/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.findAll();

        return new ResponseEntity<List<User>>(users, HttpStatus.OK);

    }

    @GetMapping(value="/getuser")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<User> getUser(Principal principal){

        User user = userService.getUserByEmail(principal.getName());

        System.out.println("****************** $$$$$$$$$$$"+principal.getName());
        return new ResponseEntity<User>(user, HttpStatus.OK);

    }

    @GetMapping(value="/getusers")
    @PreAuthorize("hasRole('OWNER')")
    public ResponseEntity<User> getDetails(Principal principal){

        User user = userService.getUserByEmail(principal.getName());

        System.out.println("****************** $$$$$$$$$$$"+principal.getName());
        return new ResponseEntity<User>(user, HttpStatus.OK);

    }
}
