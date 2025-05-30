package com.madislm.jobprocessor.service;

import com.madislm.jobprocessor.model.Job;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueueService {

    private final RabbitTemplate rabbitTemplate;

    public void enqueueJob(Job job) {
        rabbitTemplate.convertAndSend("job_queue", job.getId());
    }
}
