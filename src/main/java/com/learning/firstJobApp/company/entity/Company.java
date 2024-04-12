package com.learning.firstJobApp.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.firstJobApp.job.entity.Job;
import com.learning.firstJobApp.review.entity.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
//    @JsonIgnore//helps in reducing stackoverflow error messages
    @OneToMany(mappedBy = "company")//comapny in job entity will reference this
    //one company have many jobs
    private List<Job> jobs;
    //will add review later

    @OneToMany(mappedBy = "company")//company have many reviews
    private List<Review> reviews;
}
