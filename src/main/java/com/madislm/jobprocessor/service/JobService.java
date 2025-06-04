package com.madislm.jobprocessor.service;

import com.madislm.jobprocessor.dto.JobRequestDto;
import com.madislm.jobprocessor.exception.JobNotFoundException;
import com.madislm.jobprocessor.factory.JobFactory;
import com.madislm.jobprocessor.model.Job;
import com.madislm.jobprocessor.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;

    @Transactional
    public Job addJob(JobRequestDto jobRequestDto) {
        Job job = JobFactory.fromJobRequestDto(jobRequestDto);
        jobRepository.save(job);
        return job;
    }

    public Job getJob(Long id) {
        return jobRepository.findById(id).orElseThrow(() -> new JobNotFoundException(id));
    }
}
