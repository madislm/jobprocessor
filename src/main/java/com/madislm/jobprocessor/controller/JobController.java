package com.madislm.jobprocessor.controller;

import com.madislm.jobprocessor.dto.JobRequestDto;
import com.madislm.jobprocessor.dto.JobResponseDto;
import com.madislm.jobprocessor.mapper.JobMapper;
import com.madislm.jobprocessor.model.Job;
import com.madislm.jobprocessor.service.JobService;
import com.madislm.jobprocessor.service.QueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    private final QueueService queueService;

    private final JobMapper jobMapper;

    @PostMapping()
    public ResponseEntity<JobResponseDto> addJob(@RequestBody JobRequestDto jobRequestDto) {
        Job job = jobService.addJob(jobRequestDto);
        queueService.enqueueJob(job);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(jobMapper.jobToJobResponseDto(job));
    }
}
