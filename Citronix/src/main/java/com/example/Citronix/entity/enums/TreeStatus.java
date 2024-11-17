package com.example.Citronix.entity.enums;

import lombok.Getter;

@Getter
public enum TreeStatus {
    YOUNG("young"),
    PRODUCTIVE("productive"),
    NON_PRODUCTIVE("non-productive");

    private final String status;
    TreeStatus(String status) {
        this.status = status;
    }

}
