package com.oocl;

public class FullCapacityException extends RuntimeException{
    private static final String message = "Not enough position.";
    public FullCapacityException() {
        super(message);
    }
}
