package com.joris.potomalaka.Service;

import com.joris.potomalaka.models.User;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserService {
    private static final String API_URL = "http://localhost:8080/users";
    private static final String SAVE_USER_URL = "http://localhost:8080/save-user";


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
}
