//package com.joris.potomalaka;
//
//import org.springframework.web.client.RestTemplate;
//import java.util.Scanner;
//
//import static com.joris.potomalaka.service.InvoiceService.*;
//import static com.joris.potomalaka.service.UserService.*;
//import static com.joris.potomalaka.service.CompanyService.*;
//import static com.joris.potomalaka.service.ContactService.*;
//
//public class UserInterface {
//
//    private final Scanner scanner;
//
//    public UserInterface(Scanner scanner) {
//        this.scanner = scanner;
//    }
//
//    public void start() {
//        RestTemplate restTemplate = new RestTemplate();
//        boolean running = true;
//
//        while (running) {
//            System.out.println("\n--------------------------------------");
//            System.out.println("Welcome to our Data Management Tool!");
//            System.out.println("What topic would you like to access?");
//            System.out.println("--------------------------------------");
//            System.out.println("\n1. Invoices platform");
//            System.out.println("2. Companies platform");
//            System.out.println("3. Contacts platform");
//            System.out.println("4. Users platform");
//            System.out.println("5. Exit");
//            System.out.print("\nEnter your choice: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (choice) {
//
//                // INVOICES
//                case 1:
//                    boolean invoicePlatformRunning = true;
//
//                    while (invoicePlatformRunning) {
//                        System.out.println("\nInvoice Data Platform");
//                        System.out.println("--------------------------------------");
//                        System.out.println("1. View All Invoices");
//                        System.out.println("2. Add New Invoice");
//                        System.out.println("3. Update Invoice");
//                        System.out.println("4. Delete Invoice");
//                        System.out.println("5. Return");
//                        System.out.print("\nEnter your choice: ");
//
//                        int choiceCase1 = scanner.nextInt();
//                        scanner.nextLine(); // Consume newline
//
//                        switch (choiceCase1) {
//                            case 1:
//                                viewAllInvoices(restTemplate);
//                                break;
//                            case 2:
//                                addNewInvoice(restTemplate, scanner);
//                                break;
//                            case 3:
//                                updateInvoice(restTemplate, scanner);
//                                break;
//                            case 4:
//                                deleteInvoice(restTemplate, scanner);
//                                break;
//                            case 5:
//                                invoicePlatformRunning = false;
//                                System.out.println("Returning to main menu...");
//                                break;
//                            default:
//                                System.out.println("Invalid choice. Please try again.");
//                        }
//                    }
//                    break;
//
//                // COMPANIES
//                case 2:
//                    boolean companyPlatformRunning = true;
//
//                    while (companyPlatformRunning) {
//                        System.out.println("\nCompany Data Platform");
//                        System.out.println("--------------------------------------");
//                        System.out.println("1. View All Companies");
//                        System.out.println("2. Add New Company");
//                        System.out.println("3. Update Company");
//                        System.out.println("4. Delete Company");
//                        System.out.println("5. Return");
//                        System.out.print("\nEnter your choice: ");
//
//                        int choiceCase2 = scanner.nextInt();
//                        scanner.nextLine(); // Consume newline
//
//                        switch (choiceCase2) {
//                            case 1:
//                                viewAllCompanies(restTemplate);
//                                break;
//                            case 2:
//                                addNewCompany(restTemplate, scanner);
//                                break;
//                            case 3:
//                                updateCompany(restTemplate, scanner);
//                                break;
//                            case 4:
//                                deleteCompany(restTemplate, scanner);
//                                break;
//                            case 5:
//                                companyPlatformRunning = false;
//                                System.out.println("Returning to main menu...");
//                                break;
//                            default:
//                                System.out.println("Invalid choice. Please try again.");
//                        }
//                    }
//                    break;
//
//                // CONTACTS
//                case 3:
//                    boolean contactPlatformRunning = true;
//
//                    while (contactPlatformRunning) {
//                        System.out.println("\nContact Data Platform");
//                        System.out.println("--------------------------------------");
//                        System.out.println("1. View All Contacts");
//                        System.out.println("2. Add New Contact");
//                        System.out.println("3. Update Contact");
//                        System.out.println("4. Delete Contact");
//                        System.out.println("5. Return");
//                        System.out.print("\nEnter your choice: ");
//
//                        int choiceCase3 = scanner.nextInt();
//                        scanner.nextLine(); // Consume newline
//
//                        switch (choiceCase3) {
//                            case 1:
//                                viewAllContacts(restTemplate);
//                                break;
//                            case 2:
//                                addNewContact(restTemplate, scanner);
//                                break;
//                            case 3:
//                                updateContact(restTemplate, scanner);
//                                break;
//                            case 4:
//                                deleteContact(restTemplate, scanner);
//                                break;
//                            case 5:
//                                contactPlatformRunning = false;
//                                System.out.println("Returning to main menu...");
//                                break;
//                            default:
//                                System.out.println("Invalid choice. Please try again.");
//                        }
//                    }
//                    break;
//
//                // USERS
//                case 4:
//                    boolean userPlatformRunning = true;
//
//                    while (userPlatformRunning) {
//                        System.out.println("\nUser Data Platform");
//                        System.out.println("--------------------------------------");
//                        System.out.println("1. View All Users");
//                        System.out.println("2. Add New User");
//                        System.out.println("3. Update User");
//                        System.out.println("4. Delete User");
//                        System.out.println("5. Return");
//                        System.out.print("\nEnter your choice: ");
//
//                        int choiceCase4 = scanner.nextInt();
//                        scanner.nextLine(); // Consume newline
//
//                        switch (choiceCase4) {
//                            case 1:
//                                viewAllUsers(restTemplate);
//                                break;
//                            case 2:
//                                addNewUser(restTemplate, scanner);
//                                break;
//                            case 3:
//                                updateUser(restTemplate, scanner);
//                                break;
//                            case 4:
//                                deleteUser(restTemplate, scanner);
//                                break;
//                            case 5:
//                                userPlatformRunning = false;
//                                System.out.println("Returning to main menu...");
//                                break;
//                            default:
//                                System.out.println("Invalid choice. Please try again.");
//                        }
//                    }
//                    break;
//
//                case 5:
//                    running = false;
//                    System.out.println("Exiting application...");
//                    break;
//
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//        scanner.close();
//        System.exit(0);  // This will terminate the program
//    }
//}
