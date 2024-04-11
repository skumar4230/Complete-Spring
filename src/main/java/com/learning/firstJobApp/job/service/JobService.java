package com.learning.firstJobApp.job.service;

import com.learning.firstJobApp.job.entity.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job getJobById(Long jobId);
}
