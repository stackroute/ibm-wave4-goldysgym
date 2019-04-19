package com.stackroute.userauthentication.exception;

public class ErrorDetails {

    private String message;

    public ErrorDetails(String message) {
        this.message = message;
    }

    public ErrorDetails() {
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "message='" + message + '\'' +
                '}';
    }
}
