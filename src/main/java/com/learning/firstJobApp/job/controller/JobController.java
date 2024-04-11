package com.learning.firstJobApp.job.controller;

import com.learning.firstJobApp.job.entity.Job;
import com.learning.firstJobApp.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/jobs")
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

   @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(jobService.findAll());

    }

 @PostMapping
    public ResponseEntity<String> createJobs(@RequestBody Job job) {
        //will add new job received from body we provided
        jobService.createJob(job);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable("jobId") Long jobId) {
        Job job = jobService.getJobById(jobId);
        return new ResponseEntity(job, HttpStatus.OK);
    }
    @DeleteMapping("/{jobId}")
    public ResponseEntity<String> deleteJobById(@PathVariable("jobId")Long jobId) {
       boolean deleted= jobService.deleteJobById(jobId);
       if(deleted){
       return ResponseEntity.ok("job with id " + jobId+" deleted successfully");
    }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);

   }
   @PutMapping("/{jobId}")
    public ResponseEntity<Job> updateJob(@PathVariable("jobId")Long jobId,@RequestBody Job job){
       Job job1 =jobService.updateJobById(jobId, job);
       return new ResponseEntity<>(job1,HttpStatus.OK);
   }


}
