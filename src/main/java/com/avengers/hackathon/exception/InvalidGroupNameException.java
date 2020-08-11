package com.avengers.hackathon.exception;

public class InvalidGroupNameException extends RuntimeException {

    private static final long serialVersionUID = 975491983620149657L;
    public InvalidGroupNameException(String message) {
        super(message);
    }
}
