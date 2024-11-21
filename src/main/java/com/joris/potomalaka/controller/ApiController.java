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

    @Autowired
    private companyRepo companyRepo;

    @Autowired
    private contactRepo contactRepo;

    @Autowired
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
    public List<Company> getCompanies() {
        return companyRepo.findAll();
    }

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        return contactRepo.findAll();
    }

    @GetMapping("/invoices")
    public List<Invoice> getInvoices() {
        return invoiceRepo.findAll();
    }

}
