package com.learning.firstJobApp.company.service;

import com.learning.firstJobApp.company.entity.Company;
import com.learning.firstJobApp.job.entity.Job;

import java.util.List;

public interface CompanyService {
    List<Company> getALlCompanies();
   boolean updateCompany(Company company,Long id);
    void createCompany(Company company);
    Company getCompanyById(Long id);

    boolean deleteCompanyById(Long jobId);
}
