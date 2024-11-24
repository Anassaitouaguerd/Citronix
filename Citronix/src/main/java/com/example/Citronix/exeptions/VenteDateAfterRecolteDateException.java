package com.example.Citronix.exeptions;

public class VenteDateAfterRecolteDateException extends RuntimeException {
    private final static String DEFAULT_MESSAGE = "Vente date should be after recolte date";
    public VenteDateAfterRecolteDateException() {
        super(DEFAULT_MESSAGE);
    }
}
