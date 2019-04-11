package com.stackroute.userauthentication.security;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class JwtauthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID=-98732872387627L;
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException
    {
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,"unauthorized");
    }
}
