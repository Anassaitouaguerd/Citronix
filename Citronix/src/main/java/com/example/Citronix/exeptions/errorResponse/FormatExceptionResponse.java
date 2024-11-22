package com.example.Citronix.exeptions.errorResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormatExceptionResponse {
    private LocalDateTime timestamp;
    private String message;
    private String error;
    private int status;
}
