package com.example.Citronix.exeptions;

public class RecolteAlreadyExistsForThisSeason extends RuntimeException {
    private final static String DEFAULT_MESSAGE = "Recolte already exists for this season";
    public RecolteAlreadyExistsForThisSeason() {
        super(DEFAULT_MESSAGE);
    }
}
