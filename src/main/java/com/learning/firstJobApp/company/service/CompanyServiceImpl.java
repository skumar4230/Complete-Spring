package com.learning.firstJobApp.company.service;

import com.learning.firstJobApp.company.entity.Company;
import com.learning.firstJobApp.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getALlCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company c = companyOptional.get();
            if (c.getId().equals(id)) {
                c.setDescription(company.getDescription());
                c.setName(company.getName());
                c.setJobs(company.getJobs());
                companyRepository.save(c);
                return true;
            }

        }
        return false;
    }

    @Override
    public void createCompany(Company company) {

        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompanyById(Long id) {

        if (companyRepository.findById(id).isPresent()) {
            companyRepository.deleteById(id);
            return true;


        }
        return false;


    }
}

