package com.learning.firstJobApp.job.service;

import com.learning.firstJobApp.job.entity.Job;
import com.learning.firstJobApp.job.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    //    private List<Job> jobs = new ArrayList<>();
    //    private Long nextid = 1L;
    @Autowired
    private JobRepository jobRepo;

    @Override
    public List<Job> findAll() {
        return jobRepo.findAll();
    }

    @Override
    public void createJob(Job job) {
        //        job.setId(nextid++);//set new Id if not provided
        jobRepo.save(job);
    }

    @Override
    public Job getJobById(Long jobId) {
        return jobRepo.findById(jobId).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long jobId) {
        try {
            jobRepo.deleteById(jobId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Job updateJobById(Long jobId, @RequestBody Job job) {
        Optional<Job> jobOptional = jobRepo.findById(jobId);
        if (jobOptional.isPresent()) {
            Job j = jobOptional.get();
            if (j.getId().equals(jobId)) {
                j.setTitle(job.getTitle());
                j.setDescription(job.getDescription());
                j.setLocation(job.getLocation());
                j.setMinSalary(job.getMinSalary());
                j.setMaxSalary(job.getMaxSalary());
                jobRepo.save(j);
                return j;
            }

        }
        return new Job();
    }
}
