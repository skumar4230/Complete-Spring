package com.learning.firstJobApp.review.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.firstJobApp.company.entity.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double rating;
    @JsonIgnore
@ManyToOne//many rating to one company
    private Company company;
}
