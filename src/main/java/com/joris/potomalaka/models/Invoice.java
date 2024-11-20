package com.joris.potomalaka.models;

import jakarta.persistence.*;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String timestamp;

    @Column
    private int invoiceCompanyId;

    @Column
    private int invoiceContactId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getInvoiceCompanyId() {
        return invoiceCompanyId;
    }

    public void setInvoiceCompanyId(int invoiceCompanyId) {
        this.invoiceCompanyId = invoiceCompanyId;
    }

    public int getInvoiceContactId() {
        return invoiceContactId;
    }

    public void setInvoiceContactId(int invoiceContactId) {
        this.invoiceContactId = invoiceContactId;
    }
}
