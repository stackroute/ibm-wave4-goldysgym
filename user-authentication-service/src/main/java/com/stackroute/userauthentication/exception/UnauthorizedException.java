package com.stackroute.userauthentication.exception;


import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnauthorizedException extends RuntimeException {

    protected static final MessageSourceAccessor message = SpringSecurityMessageSource.getAccessor();

    public UnauthorizedException() {
        super(message.getMessage("AbstractAcessDecisionManager.accessDenied", "Access is Denied"));
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
