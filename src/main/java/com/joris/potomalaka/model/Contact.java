package com.joris.potomalaka.model;

import jakarta.persistence.*;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String timestamp;

    @Column
    private long contactCompanyId;

    public Contact(long contactId, String newFirstName, String newLastName, String newPhone, String newEmail, String newTimestamp, long newContactCompanyId) {
        this.id = contactId;
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.phone = newPhone;
        this.email = newEmail;
        this.timestamp = newTimestamp;
        this.contactCompanyId = newContactCompanyId;
    }

    public Contact() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public long getContactCompanyId() {
        return contactCompanyId;
    }

    public void setContactCompanyId(long contactCompanyId) {
        this.contactCompanyId = contactCompanyId;
    }
}
