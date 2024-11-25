package com.joris.potomalaka.controller;

import com.joris.potomalaka.models.Company;
import com.joris.potomalaka.repository.companyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private companyRepo companyRepo;

    //GET REQUESTS
    @GetMapping("/companies")
    public List<Company> getCompanies() {
        return companyRepo.findAll();
    }

    //POST REQUESTS
    @PostMapping("/save-company")
    public String saveCompany(@RequestBody Company company) {
        companyRepo.save(company);
        return "Company saved...";
    }

    //PUT REQUESTS
    @PutMapping(value = "update/company/{Id}")
    public String updateCompany(@PathVariable long Id, @RequestBody Company company) {
        Company updateCompany = companyRepo.findById(Id).get();
        updateCompany.setName(company.getName());
        updateCompany.setCountry(company.getCountry());
        updateCompany.setVat(company.getVat());
        updateCompany.setType(company.getType());
        updateCompany.setTimestamp(company.getTimestamp());
        companyRepo.save(updateCompany);
        return "Updated company...";
    }

    //DELETE REQUESTS
    @DeleteMapping("/delete/company/{Id}")
    public String deleteCompany(@PathVariable long Id) {
        Company deleteCompany = companyRepo.findById(Id).get();
        companyRepo.delete(deleteCompany);
        return "Deleted company with Id " + Id;
    }
}
