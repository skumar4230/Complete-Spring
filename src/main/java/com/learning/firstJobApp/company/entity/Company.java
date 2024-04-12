package com.learning.firstJobApp.company.entity;

import com.learning.firstJobApp.job.entity.Job;
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
    @OneToMany//one company have many jobs
    private List<Job> jobs;
    //will add review later
}
