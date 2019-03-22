package com.stackroute.playerservice.exceptions;

/**
 * Custom exception to handle existing player conflicts conditions
 */

public class PlayerAlreadyExistsException extends Exception {
    public PlayerAlreadyExistsException(String message) {
        super(message);
    }
}
