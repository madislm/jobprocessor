package com.madislm.jobprocessor.exception;

import lombok.Getter;

@Getter
public class JobNotFoundException extends RuntimeException {

    private final Long id;

    public JobNotFoundException(Long id) {
        this.id = id;
    }
}
