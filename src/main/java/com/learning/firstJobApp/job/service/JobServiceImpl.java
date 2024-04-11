package com.learning.firstJobApp.job.service;

import com.learning.firstJobApp.job.entity.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextid = 1L;
    private Job job;
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextid++);//set new Id if not provided
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long jobId) {
        for (Job job : jobs) {
            if (job.getId().equals(jobId)) {
                return job;
            }
        }
        return null;
    }
}
