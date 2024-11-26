package com.joris.potomalaka.models;

import jakarta.persistence.*;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String invoiceNumber;

    @Column
    private int amount;

    @Column
    private String invoiceDate;

    @Column
    private long invoiceCompanyId;

    @Column
    private long invoiceContactId;

    @Column
    private String timestamp;

    public Invoice(long invoiceId, String newInvoiceNumber, int newAmount, String newInvoiceDate, long newInvoiceCompanyId, long newInvoiceContactId, String newTimestamp) {
        this.id = invoiceId;
        this.invoiceNumber = newInvoiceNumber;
        this.amount = newAmount;
        this.invoiceDate = newInvoiceDate;
        this.invoiceCompanyId = newInvoiceCompanyId;
        this.invoiceContactId = newInvoiceContactId;
        this.timestamp = newTimestamp;
    }

    public Invoice() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public long getInvoiceCompanyId() {
        return invoiceCompanyId;
    }

    public void setInvoiceCompanyId(long invoiceCompanyId) {
        this.invoiceCompanyId = invoiceCompanyId;
    }

    public long getInvoiceContactId() {
        return invoiceContactId;
    }

    public void setInvoiceContactId(long invoiceContactId) {
        this.invoiceContactId = invoiceContactId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
