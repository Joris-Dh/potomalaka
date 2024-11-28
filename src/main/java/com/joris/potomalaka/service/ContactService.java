//package com.joris.potomalaka.service;
//
//import com.joris.potomalaka.model.Contact;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//
//public class ContactService {
//    private static final String API_URL = "http://localhost:8080/contacts";
//    private static final String SAVE_CONTACT_URL = "http://localhost:8080/save-contact";
//    private static final String DELETE_CONTACT_URL = "http://localhost:8080/delete/contact/{Id}";
//    private static final String UPDATE_CONTACT_URL = "http://localhost:8080/update/contact/{Id}";
//
//    //VIEW ALL CONTACTS
//    public static void viewAllContacts(RestTemplate restTemplate) {
//        try {
//            Contact[] contactsArray = restTemplate.getForObject(API_URL, Contact[].class);
//            List<Contact> contacts = Arrays.asList(contactsArray);
//            System.out.println("\nContact List:");
//            System.out.printf("%-5s %-15s %-15s %-20s %-35s %-20s %-20s\n", "ID", "Firstname", "Lastname", "Phone", "Email", "Timestamp", "Contact Company ID");
//            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
//            for (Contact contact : contacts) {
//                System.out.printf("%-5s %-15s %-15s %-20s %-35s %-20s %-20s\n", contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getPhone(), contact.getEmail(), contact.getTimestamp(), contact.getContactCompanyId());
//            }
//        } catch (Exception e) {
//            System.out.println("Error fetching users: " + e.getMessage());
//        }
//    }
//
//    //ADD NEW CONTACT
//    public static void addNewContact(RestTemplate restTemplate, Scanner scanner) {
//        try {
//            System.out.print("Enter Firstname: ");
//            String firstName = scanner.nextLine();
//            System.out.print("Enter Lastname: ");
//            String lastName = scanner.nextLine();
//            System.out.print("Enter Phone: ");
//            String phone = scanner.nextLine();
//            System.out.print("Enter Email: ");
//            String email = scanner.nextLine();
//            System.out.print("Enter Timestamp: ");
//            String timestamp = scanner.nextLine();
//            System.out.print("Enter Contact Company ID: ");
//            long contactCompanyId = Long.parseLong(scanner.nextLine());
//
//            Contact newContact = new Contact();
//            newContact.setFirstName(firstName);
//            newContact.setLastName(lastName);
//            newContact.setPhone(phone);
//            newContact.setEmail(email);
//            newContact.setTimestamp(timestamp);
//            newContact.setContactCompanyId(contactCompanyId);
//
//            String response = restTemplate.postForObject(SAVE_CONTACT_URL, newContact, String.class);
//            System.out.println(response);
//        } catch (Exception e) {
//            System.out.println("Error adding contact: " + e.getMessage());
//        }
//    }
//
//    //UPDATE CONTACT
//    public static void updateContact(RestTemplate restTemplate, Scanner scanner) {
//        try {
//            System.out.println("What's the ID of the Contact you want to update?");
//            long contactId = Long.parseLong(scanner.nextLine());
//
//            System.out.println("Enter new Firstname:");
//            String newFirstName = scanner.nextLine();
//            System.out.println("Enter new Lastname:");
//            String newLastName = scanner.nextLine();
//            System.out.println("Enter new Phone:");
//            String newPhone = scanner.nextLine();
//            System.out.println("Enter new Email:");
//            String newEmail = scanner.nextLine();
//            System.out.println("Enter new Timestamp:");
//            String newTimestamp = scanner.nextLine();
//            System.out.println("Enter new Contact Company Id:");
//            long newContactCompanyId = Long.parseLong(scanner.nextLine());
//
//            Contact updatedContact = new Contact(contactId, newFirstName, newLastName, newPhone, newEmail, newTimestamp, newContactCompanyId);
//            restTemplate.put(UPDATE_CONTACT_URL, updatedContact, contactId);
//            System.out.println("\nUser with ID " + contactId + " has been updated.");
//
//        } catch (Exception e) {
//            System.out.println("Error occurred while updating user: " + e.getMessage());
//        }
//    }
//
//    //DELETE CONTACT
//    public static void deleteContact(RestTemplate restTemplate, Scanner scanner) {
//        try {
//            System.out.println("What's the ID of the Contact you want to delete?");
//            String input = scanner.nextLine();
//            restTemplate.delete(DELETE_CONTACT_URL, input);
//            System.out.println("\nContact with ID " + input + " has been deleted.");
//        } catch (Exception e) {
//            System.out.println("Error adding contact: " + e.getMessage());
//        }
//    }
//}
