package com.avengers.hackathon.exception;

public class ProductNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 975491983620149657L;
    public ProductNotFoundException(String message) {
        super(message);
    }
}
