package com.stackroute.jwt.jwtfirst.controller;


import com.stackroute.jwt.jwtfirst.domain.Response;
import com.stackroute.jwt.jwtfirst.domain.User;
import com.stackroute.jwt.jwtfirst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PreLoginController {

    private UserService userService;
    @Autowired
    public PreLoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/registration")
    public ResponseEntity<?> registration(@RequestBody User user) {
       user.setRole("USER");
       if (userService.getUserByEmail(user.getEmail())==null) {
            User dbUser = userService.save(user);
            return new ResponseEntity<String>("User is saved successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<String>("User is already exists", HttpStatus.CONFLICT);

        }
    }

    @PostMapping(value = "/registrationOwner")
    public ResponseEntity<Response> registrationAdmin(@RequestBody User user) {
        user.setRole("OWNER");
        System.out.println(user.getRole());
        User dbUser = userService.save(user);

        if (dbUser != null) {
            return new ResponseEntity<Response>(new Response("User is saved successfully"), HttpStatus.OK);
        }
        return null;
    }

}



