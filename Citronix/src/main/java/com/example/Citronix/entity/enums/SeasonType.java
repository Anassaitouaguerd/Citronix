package com.example.Citronix.entity.enums;

import lombok.Getter;

@Getter
public enum SeasonType {
    WINTER("winter"),
    SPRING("spring"),
    SUMMER("summer"),
    FALL("fall");

    private final String seasonType;

    SeasonType(String seasonType) {
        this.seasonType = seasonType;
    }
}
