package com.example.Citronix.exeptions;

public class ArbreNotBelongsToChampException extends RuntimeException {
    private final static String DEFAULT_MESSAGE = "Arbre not belongs to champ";
    public ArbreNotBelongsToChampException() {
        super(DEFAULT_MESSAGE);
    }
}
