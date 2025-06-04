package com.madislm.jobprocessor.exception;

import com.madislm.jobprocessor.exception.details.ErrorDetail;
import com.madislm.jobprocessor.exception.details.JobNotFoundDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleJobNotFound(JobNotFoundException ex) {
        ErrorDetail errorDetail = new JobNotFoundDetail(ex.getId());
        ErrorResponse errorResponse = new ErrorResponse("Job not found", errorDetail);
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
