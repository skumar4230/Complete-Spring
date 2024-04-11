package com.learning.firstJobApp.job.service;

import com.learning.firstJobApp.job.entity.Job;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.Iterator;
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

    @Override
    public boolean deleteJobById(Long jobId) {
        Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext()) {
            Job job = iterator.next();
            if (job.getId().equals(jobId)) {
                iterator.remove();
                return true;
            }
        }
        return false;

    }
    @Override
    public Job updateJobById(Long jobId, @RequestBody Job job) {
        for (Job j : jobs){
            if(j.getId().equals(jobId)){
                j.setTitle(job.getTitle());
                j.setDescription(job.getDescription());
                j.setLocation(job.getLocation());
                j.setMinSalary(job.getMinSalary());
                j.setMaxSalary(job.getMaxSalary());
                return j;
            }

            }
        return new Job();
        }
}
