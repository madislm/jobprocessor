package com.madislm.jobprocessor.exception;

public class JobNotFoundException extends RuntimeException {
    public JobNotFoundException(Long id) {
        super("Job with ID " + id + " not found");
    }
}
