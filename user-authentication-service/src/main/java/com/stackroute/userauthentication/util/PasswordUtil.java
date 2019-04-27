package com.stackroute.userauthentication.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

    private PasswordUtil(){
        throw new IllegalStateException("Utility class");
    }

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String getPasswordHash(String password) {


        return encoder.encode(password);


    }
}
