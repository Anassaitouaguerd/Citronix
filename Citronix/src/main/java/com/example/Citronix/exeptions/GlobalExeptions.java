package com.example.Citronix.exeptions;

import com.example.Citronix.exeptions.errorResponse.FormatExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExeptions {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NumberOfChampsLimitException.class)
    public ResponseEntity<FormatExceptionResponse> handleNumberOfChampsLimitException(NumberOfChampsLimitException ex) {
        FormatExceptionResponse exceptionResponse = new FormatExceptionResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                "CHAMPS_LIMIT_EXCEEDED",
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TreePlantingException.class)
    public ResponseEntity<FormatExceptionResponse> handleTreePlantingException(TreePlantingException ex) {
        FormatExceptionResponse exceptionResponse = new FormatExceptionResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                "TREE_PLANTING_EXCEPTION",
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
