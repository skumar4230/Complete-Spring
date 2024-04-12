package com.learning.firstJobApp.job.repository;

import com.learning.firstJobApp.job.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface JobRepository extends JpaRepository<Job,Long> {
    //provides basic crud operations without implementing along with pagination and sorting

}
