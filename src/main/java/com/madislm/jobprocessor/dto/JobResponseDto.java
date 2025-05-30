package com.madislm.jobprocessor.dto;

import com.madislm.jobprocessor.model.JobStatus;

public record JobResponseDto(Long jobId, JobStatus status) {
}
