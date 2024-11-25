package com.joris.potomalaka.controller;

import com.joris.potomalaka.models.*;
import com.joris.potomalaka.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    //GET REQUESTS
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


    //POST REQUESTS
    @PostMapping("/save-user")
    public String saveUser(@RequestBody User user) {
        userRepo.save(user);
        return "User saved...";
    }

    @PostMapping("/save-company")
    public String saveCompany(@RequestBody Company company) {
        companyRepo.save(company);
        return "Company saved...";
    }

    @PostMapping("/save-contact")
    public String saveContact(@RequestBody Contact contact) {
        contactRepo.save(contact);
        return "Contact saved...";
    }

    @PostMapping("/save-invoice")
    public String saveInvoice(@RequestBody Invoice invoice) {
        invoiceRepo.save(invoice);
        return "Invoice saved...";
    }


    //PUT REQUESTS
    @PutMapping("/update/user/{Id}")
    public String updateUser(@PathVariable long Id, @RequestBody User user) {
        User updateUser = userRepo.findById(Id).orElseThrow(() -> new RuntimeException("User not found with ID: " + Id));
        updateUser.setUsername(user.getUsername());
        updateUser.setPassword(user.getPassword());
        updateUser.setRole(user.getRole());
        userRepo.save(updateUser);
        return "Updated user...";
    }

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

    @PutMapping(value = "update/contact/{Id}")
    public String updateContact(@PathVariable long Id, @RequestBody Contact contact) {
        Contact updateContact = contactRepo.findById(Id).get();
        updateContact.setFirstName(contact.getFirstName());
        updateContact.setLastName(contact.getLastName());
        updateContact.setPhone(contact.getPhone());
        updateContact.setEmail(contact.getEmail());
        updateContact.setTimestamp(contact.getTimestamp());
        updateContact.setContactCompanyId(contact.getContactCompanyId());
        contactRepo.save(updateContact);
        return "Updated contact...";
    }

    @PutMapping(value = "update/invoice/{Id}")
    public String updateInvoice(@PathVariable long Id, @RequestBody Invoice invoice) {
        Invoice updateInvoice = invoiceRepo.findById(Id).get();
        updateInvoice.setTimestamp(invoice.getTimestamp());
        updateInvoice.setInvoiceCompanyId(invoice.getInvoiceCompanyId());
        updateInvoice.setInvoiceContactId(invoice.getInvoiceContactId());
        invoiceRepo.save(updateInvoice);
        return "Updated invoice...";
    }


    //DELETE REQUESTS
    @DeleteMapping("/delete/user/{Id}")
    public String deleteUser(@PathVariable long Id) {
        User deleteUser = userRepo.findById(Id).get();
        userRepo.delete(deleteUser);
        return "Deleted user with Id " + Id;
    }

    @DeleteMapping("/delete/company/{Id}")
    public String deleteCompany(@PathVariable long Id) {
        Company deleteCompany = companyRepo.findById(Id).get();
        companyRepo.delete(deleteCompany);
        return "Deleted company with Id " + Id;
    }

    @DeleteMapping("/delete/contact/{Id}")
    public String deleteContact(@PathVariable long Id) {
        Contact deleteContact = contactRepo.findById(Id).get();
        contactRepo.delete(deleteContact);
        return "Deleted contact with Id " + Id;
    }

    @DeleteMapping("/delete/invoice/{Id}")
    public String deleteInvoice(@PathVariable long Id) {
        Invoice deleteInvoice = invoiceRepo.findById(Id).get();
        invoiceRepo.delete(deleteInvoice);
        return "Deleted invoice with Id " + Id;
    }
}
