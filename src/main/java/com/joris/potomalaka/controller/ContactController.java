package com.joris.potomalaka.controller;

import com.joris.potomalaka.models.Contact;
import com.joris.potomalaka.repository.contactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private contactRepo contactRepo;

    //GET REQUESTS
    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        return contactRepo.findAll();
    }

    //POST REQUESTS
    @PostMapping("/save-contact")
    public String saveContact(@RequestBody Contact contact) {
        contactRepo.save(contact);
        return "Contact saved...";
    }

    //PUT REQUESTS
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

    //DELETE REQUESTS
    @DeleteMapping("/delete/contact/{Id}")
    public String deleteContact(@PathVariable long Id) {
        Contact deleteContact = contactRepo.findById(Id).get();
        contactRepo.delete(deleteContact);
        return "Deleted contact with Id " + Id;
    }
}
