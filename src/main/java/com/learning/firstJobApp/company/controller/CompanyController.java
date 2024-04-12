package com.learning.firstJobApp.company.controller;

import com.learning.firstJobApp.company.entity.Company;
import com.learning.firstJobApp.company.service.CompanyService;
import com.learning.firstJobApp.job.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {

        return new ResponseEntity<>(companyService.getALlCompanies(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        companyService.updateCompany(company, id);
        return ResponseEntity.ok("Company updated successfully");
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        return new ResponseEntity<>("Company added successfully", HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Company company = companyService.getCompanyById(id);
        if (company != null){
        return new ResponseEntity<>(company, HttpStatus.OK);
    }
    else {return new ResponseEntity<>( HttpStatus.NOT_FOUND);}
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id) {
        boolean deleted= companyService.deleteCompanyById(id);
        if(deleted){
            return ResponseEntity.ok("company with id " + id+" deleted successfully");
        }
        return new ResponseEntity<>("no data found for given comapny Id:"+id,HttpStatus.NOT_FOUND);

    }


}
