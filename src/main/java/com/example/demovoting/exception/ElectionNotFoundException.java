package com.example.demovoting.exception;

public class ElectionNotFoundException extends RuntimeException {

    public ElectionNotFoundException(String message) {
        super(message);
    }

    public ElectionNotFoundException() {
    }

    @Override
    public String toString() {
        return "ElectionNotFoundException{}";
    }
}
