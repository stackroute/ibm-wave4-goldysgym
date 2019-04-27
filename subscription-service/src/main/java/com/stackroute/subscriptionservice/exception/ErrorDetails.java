package com.stackroute.subscriptionservice.exception;

import java.util.Date;


public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails() {
    }

    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
