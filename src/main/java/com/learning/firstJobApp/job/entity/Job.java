package com.learning.firstJobApp.job.entity;
//we are importing from jakarta.persistence from spring 3
import com.learning.firstJobApp.company.entity.Company;
import jakarta.persistence.*;
import lombok.*;

//these all annotation are from lombok dependency
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity//marks this class as Entity class which will act as table for db with default name is class Name
//@Table(name = "job_table")//custom name for table in db
public class Job {
    @Id//for primarry key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    @ManyToOne//many jobs to one company
    private Company company;

}
