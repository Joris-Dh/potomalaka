package com.joris.potomalaka.service;

import com.joris.potomalaka.models.User;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserService {
    private static final String API_URL = "http://localhost:8080/users";
    private static final String SAVE_USER_URL = "http://localhost:8080/save-user";
    private static final String DELETE_USER_URL = "http://localhost:8080/delete/user/{Id}";
    private static final String UPDATE_USER_URL = "http://localhost:8080/update/user/{Id}";

    //VIEW ALL USERS
    public static void viewAllUsers(RestTemplate restTemplate) {
        try {
            User[] usersArray = restTemplate.getForObject(API_URL, User[].class);
            List<User> users = Arrays.asList(usersArray);
            System.out.println("\nUser List:");
            System.out.printf("%-5s %-20s %-10s\n", "ID", "Username", "Role");
            System.out.println("--------------------------------------");
            for (User user : users) {
                System.out.printf("%-5d %-20s %-10s\n", user.getId(), user.getUsername(), user.getRole());
            }
        } catch (Exception e) {
            System.out.println("Error fetching users: " + e.getMessage());
        }
    }

    //ADD NEW USER
    public static void addNewUser(RestTemplate restTemplate, Scanner scanner) {
        try {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            System.out.print("Enter Role: ");
            String role = scanner.nextLine();

            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser.setRole(role);

            String response = restTemplate.postForObject(SAVE_USER_URL, newUser, String.class);
            System.out.println(response);
        } catch (Exception e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }

    //UPDATE USER
    public static void updateUser(RestTemplate restTemplate, Scanner scanner) {
        try {
            System.out.println("What's the ID of the User you want to update?");
            long userId = Long.parseLong(scanner.nextLine());

            System.out.println("Enter new username:");
            String newUsername = scanner.nextLine();
            System.out.println("Enter new password:");
            String newPassword = scanner.nextLine();
            System.out.println("Enter new role:");
            String newRole = scanner.nextLine();

            // Validate required fields
            if (newUsername.isEmpty() || newPassword.isEmpty() || newRole.isEmpty()) {
                System.out.println("All fields (username, password, role) are required. Please try again.");
                return;
            }

            User updatedUser = new User(userId, newUsername, newPassword, newRole);
            restTemplate.put(UPDATE_USER_URL, updatedUser, userId);
            System.out.println("\nUser with ID " + userId + " has been updated.");

        } catch (Exception e) {
            // Handle errors (e.g., invalid input, server issues)
            System.out.println("Error occurred while updating user: " + e.getMessage());
        }
    }

    //DELETE USER
    public static void deleteUser(RestTemplate restTemplate, Scanner scanner) {
        try {
            System.out.println("What's the ID of the User you want to delete?");
            String input = scanner.nextLine();
            restTemplate.delete(DELETE_USER_URL, input);
            System.out.println("\nUser with ID " + input + " has been deleted.");
        } catch (Exception e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }
}
