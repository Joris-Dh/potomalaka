package com.joris.potomalaka;

import org.springframework.web.client.RestTemplate;
import java.util.Scanner;

import static com.joris.potomalaka.service.UserService.*;

public class UserInterface {

    private final Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        RestTemplate restTemplate = new RestTemplate();
        boolean running = true;

        while (running) {
            System.out.println("\n--------------------------------------");
            System.out.println("Welcome to our Data Management Tool!");
            System.out.println("What topic would you like to access?");
            System.out.println("--------------------------------------");
            System.out.println("\n1. Invoices platform");
            System.out.println("2. Companies platform");
            System.out.println("3. Contacts platform");
            System.out.println("4. Users platform");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("output of choice 1");
                    break;

                case 2:
                    System.out.println("output of choice 2");
                    break;

                case 3:
                    System.out.println("output of choice 3");
                    break;

                case 4:
                    boolean userPlatformRunning = true;
                    while (userPlatformRunning) {
                        // Display Menu
                        System.out.println("\nUser Data Platform");
                        System.out.println("--------------------------------------");
                        System.out.println("1. View All Users");
                        System.out.println("2. Add New User");
                        System.out.println("3. Update User");
                        System.out.println("4. Delete User");
                        System.out.println("5. Exit");
                        System.out.print("\nEnter your choice: ");

                        int choiceCase4 = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (choiceCase4) {
                            case 1:
                                // Fetch and display users
                                viewAllUsers(restTemplate);
                                break;

                            case 2:
                                // Add a new user
                                addNewUser(restTemplate, scanner);
                                break;

                            case 3:
                                // Add a new user
                                updateUser(restTemplate, scanner);
                                break;

                            case 4:
                                // Delete a new user
                                deleteUser(restTemplate, scanner);
                                break;

                            case 5:
                                // Exit the application
                                userPlatformRunning = false;
                                System.out.println("Returning to main menu...");
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
                    break;

                case 5:
                    // Exit the entire program
                    running = false;
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();  // Close the scanner when the application ends
        System.exit(0);  // This will terminate the program
    }
}
