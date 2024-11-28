package com.joris.potomalaka.model;

import jakarta.persistence.*;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String country;

    @Column
    private String vat;

    @Column
    private String type;

    @Column
    private String timestamp;

    public Company(long companyId, String newName, String newCountry, String newTimestamp, String newType, String newVat) {
        this.id = companyId;
        this.name = newName;
        this.country = newCountry;
        this.timestamp = newTimestamp;
        this.type = newType;
        this.vat = newVat;
    }

    public Company() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
