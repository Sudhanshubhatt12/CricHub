package com.Cricbuzz.cricbuzz.exception;

public class TeamNotFoundException extends RuntimeException{

    public TeamNotFoundException(String message) {
        super(message);
    }
}
