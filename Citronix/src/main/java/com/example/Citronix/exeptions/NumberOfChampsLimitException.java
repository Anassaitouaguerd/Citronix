package com.example.Citronix.exeptions;

public class NumberOfChampsLimitException extends RuntimeException{
    private static final String DEFAULT_MESSAGE = "Number of fields limit reached: A farm cannot contain more than 10 fields";
    public NumberOfChampsLimitException() {
        super(DEFAULT_MESSAGE);
    }
}
