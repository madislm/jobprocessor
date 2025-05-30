package com.madislm.jobprocessor.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String JOB_QUEUE = "job_queue";

    @Bean
    public Queue jobQueue() {
        return QueueBuilder.durable(JOB_QUEUE).build();
    }
}
