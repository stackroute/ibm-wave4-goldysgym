package com.stackroute.userauthentication.controller;

import com.stackroute.userauthentication.dto.UserDTO;
import com.stackroute.userauthentication.domain.User;
import com.stackroute.userauthentication.security.JwtTokenUtil;
import com.stackroute.userauthentication.security.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//AuthenticationController that has API exposed to generate JWT token.

@RestController
public class AuthenticationController {

    @Value("${jwt.header}")
    private String tokenHeader;

    private JwtTokenUtil jwtTokenUtil;

    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationController(JwtTokenUtil jwtTokenUtil, AuthenticationManager authenticationManager) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            final JwtUser userDetails = (JwtUser) authentication.getPrincipal();
            SecurityContextHolder.getContext().setAuthentication(authentication);
            final String token = jwtTokenUtil.generateToken(userDetails);
            response.setHeader("Token", token);

            return new ResponseEntity<>(new UserDTO(userDetails.getUser(), token), HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>("email id or password is worng ", HttpStatus.CONFLICT);
        }

    }
}
