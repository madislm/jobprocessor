package com.madislm.jobprocessor.exception;

import com.madislm.jobprocessor.exception.details.ErrorDetail;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {

    private final String error;
    private final ErrorDetail errorDetail;
    private final LocalDateTime timestamp;

    public ErrorResponse(String error, ErrorDetail errorDetail) {
        this.error = error;
        this.errorDetail = errorDetail;
        this.timestamp = LocalDateTime.now();
    }
}
