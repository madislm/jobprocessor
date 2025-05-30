package com.madislm.jobprocessor.worker;

import com.madislm.jobprocessor.config.RabbitConfig;
import com.madislm.jobprocessor.model.Job;
import com.madislm.jobprocessor.model.JobStatus;
import com.madislm.jobprocessor.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class JobWorker {

    private final JobRepository jobRepository;

    @RabbitListener(queues = RabbitConfig.JOB_QUEUE)
    public void receive(Long jobId) {
        process(jobId);
    }

    @Transactional
    private void process(Long jobId) {
        Job job = jobRepository.findById(jobId).orElseThrow();
        try {
            job.setStatus(JobStatus.RUNNING);
            job.setLastUpdatedAt(LocalDateTime.now());
            jobRepository.save(job);

            String result = imitateProcessing(job.getPayload());
            job.setResult(result);
            job.setStatus(JobStatus.SUCCESS);
        } catch (Exception e) {
            job.setStatus(JobStatus.FAILED);
            job.setRetryCount(job.getRetryCount() + 1);
        } finally {
            job.setLastUpdatedAt(LocalDateTime.now());
            jobRepository.save(job);
        }
    }

    private String imitateProcessing(String payload) throws InterruptedException {
        // TODO
        Thread.sleep(1000);
        return "Done";
    }
}
