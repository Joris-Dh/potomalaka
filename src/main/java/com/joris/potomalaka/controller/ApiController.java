package com.joris.potomalaka.controller;

import com.joris.potomalaka.models.*;
import com.joris.potomalaka.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private userRepo userRepo;
    private companyRepo companyRepo;
    private contactRepo contactRepo;
    private invoiceRepo invoiceRepo;

    @GetMapping("/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/companies")
    public List<Company> getCompany() {
        return companyRepo.findAll();
    }

    @GetMapping("/contact")
    public List<Contact> getContact() {
        return contactRepo.findAll();
    }

    @GetMapping("/invoices")
    public List<Invoice> getInvoices() {
        return invoiceRepo.findAll();
    }

}
