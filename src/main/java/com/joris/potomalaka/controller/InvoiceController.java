package com.joris.potomalaka.controller;

import com.joris.potomalaka.model.Invoice;
import com.joris.potomalaka.repo.invoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    private invoiceRepo invoiceRepo;

    //GET REQUESTS
    @GetMapping("/invoices")
    public List<Invoice> getInvoices() {
        return invoiceRepo.findAll();
    }

    //POST REQUESTS
    @PostMapping("/save-invoice")
    public String saveInvoice(@RequestBody Invoice invoice) {
        invoiceRepo.save(invoice);
        return "Invoice saved...";
    }

    //PUT REQUESTS
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
    @DeleteMapping("/delete/invoice/{Id}")
    public String deleteInvoice(@PathVariable long Id) {
        Invoice deleteInvoice = invoiceRepo.findById(Id).get();
        invoiceRepo.delete(deleteInvoice);
        return "Deleted invoice with Id " + Id;
    }
}
