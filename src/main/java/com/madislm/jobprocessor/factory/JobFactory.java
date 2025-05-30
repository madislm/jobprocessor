package com.madislm.jobprocessor.factory;

import com.madislm.jobprocessor.dto.JobRequestDto;
import com.madislm.jobprocessor.model.Job;
import com.madislm.jobprocessor.model.JobStatus;

import java.time.LocalDateTime;

public class JobFactory {

    public static Job fromJobRequestDto(JobRequestDto jobRequestDto) {
        LocalDateTime currentTime = LocalDateTime.now();
        return Job.builder()
                .type(jobRequestDto.type())
                .payload(jobRequestDto.payload())
                .status(JobStatus.QUEUED)
                .createdAt(currentTime)
                .lastUpdatedAt(currentTime)
                .retryCount(0)
                .build();
    }
}
