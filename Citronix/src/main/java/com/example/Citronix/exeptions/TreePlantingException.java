package com.example.Citronix.exeptions;

public class TreePlantingException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Trees can only be planted between the months of March\n" +
            "and May, which is the ideal period for the climate.";

    public TreePlantingException() {
        super(DEFAULT_MESSAGE);
    }
}
