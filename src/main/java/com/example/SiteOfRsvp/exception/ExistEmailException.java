package com.example.SiteOfRsvp.exception;

public class ExistEmailException extends RuntimeException{

    public ExistEmailException(String message) {
        super(message);
    }
}
