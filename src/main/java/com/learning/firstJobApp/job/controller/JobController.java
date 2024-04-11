package com.learning.firstJobApp.job.controller;

import com.learning.firstJobApp.job.entity.Job;
import com.learning.firstJobApp.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController {
    //if we are not using database connection

    //    private final List<Job> existingjobs = Arrays.asList(
    //            new
    //
    //                    Job(1L, "Software Engineer", "Develop software applications", "50000", "100000", "New York"),
    //            new
    //
    //                    Job(2L, "Data Scientist", "Analyze data to gain insights", "60000", "120000", "San Francisco"),
    //            new
    //
    //                    Job(3L, "Project Manager", "Manage project timelines and resources", "70000", "130000", "Chicago")
    //    );
    //    private List<Job> jobs = new ArrayList<>(existingjobs);

    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobService.findAll();

    }

    @PostMapping("/jobs")
    public String createJobs(@RequestBody Job job) {
        //will add new job received from body we provided
        jobService.createJob(job);
        return "success";
    }

}
