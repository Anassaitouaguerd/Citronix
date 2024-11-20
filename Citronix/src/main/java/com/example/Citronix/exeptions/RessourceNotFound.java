package com.example.Citronix.exeptions;

public class RessourceNotFound extends RuntimeException{
    public RessourceNotFound(String message) {
        super(message);
    }
}
