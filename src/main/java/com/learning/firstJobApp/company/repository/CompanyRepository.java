package com.learning.firstJobApp.company.repository;

import com.learning.firstJobApp.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Long> {

}
