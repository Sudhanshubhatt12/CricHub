package com.Cricbuzz.cricbuzz.exception;


public class MatchNotFoundException extends RuntimeException {

    public MatchNotFoundException(String message) {
        super(message);
    }
}