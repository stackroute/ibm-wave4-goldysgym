package com.stackroute.playerservice.exceptions;

/**
 * Custom Exception to handle conditions where players were not found
 */

public class PlayerNotFoundException extends Exception {

    public PlayerNotFoundException(String s) {
        super(s);
    }

}
