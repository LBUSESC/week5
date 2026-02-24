package com.unistudycricle.student_service.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class APIError {
    private LocalDateTime timestamp;
    private String errorMessage;
    private HttpStatus statusCode;

    public APIError(LocalDateTime timestamp, String errorMessage, HttpStatus statusCode) {
        this.timestamp = timestamp;
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }
}
