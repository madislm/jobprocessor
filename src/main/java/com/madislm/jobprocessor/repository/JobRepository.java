package com.madislm.jobprocessor.repository;


import com.madislm.jobprocessor.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
