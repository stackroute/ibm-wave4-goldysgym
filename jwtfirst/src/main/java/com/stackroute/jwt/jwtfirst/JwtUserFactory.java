package com.stackroute.jwt.jwtfirst;

import com.stackroute.jwt.jwtfirst.model.User;
import com.stackroute.jwt.jwtfirst.security.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class JwtUserFactory {

    public static JwtUser create(User user) {
        return new JwtUser(user.getId(),user.getEmail(),user.getPassword(),user, maptoGrantedAuthorities(new ArrayList<String>(Arrays.asList("ROLE_"+user.getRole()))),user.isEnabled());
    }

    private static List<GrantedAuthority> maptoGrantedAuthorities(ArrayList<String> authorities) {
        return authorities.stream().map(Authority -> new SimpleGrantedAuthority(Authority)).collect(Collectors.toList());
    }
}
