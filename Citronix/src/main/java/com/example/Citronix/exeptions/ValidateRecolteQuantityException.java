package com.example.Citronix.exeptions;

public class ValidateRecolteQuantityException extends RuntimeException {
    private final static String DEFAULT_MESSAGE = "Quantity is greater than arbre quantity";
    public ValidateRecolteQuantityException() {
        super(DEFAULT_MESSAGE);
    }
}
