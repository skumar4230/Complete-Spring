package com.learning.firstJobApp.job.service;

import com.learning.firstJobApp.job.entity.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService {
    List<Job> findAll();
    void createJob();
}
