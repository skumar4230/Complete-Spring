package com.learning.firstJobApp.job.entity;

import lombok.*;

//these all annotation are from lombok dependency
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

}
