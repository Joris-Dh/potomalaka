package com.joris.potomalaka.service;

import com.joris.potomalaka.models.Company;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CompanyService {
    private static final String API_URL = "http://localhost:8080/companies";
    private static final String SAVE_COMPANY_URL = "http://localhost:8080/save-company";
    private static final String DELETE_COMPANY_URL = "http://localhost:8080/delete/company/{Id}";
    private static final String UPDATE_COMPANY_URL = "http://localhost:8080/update/company/{Id}";

    //VIEW ALL COMPANIES
    public static void viewAllCompanies(RestTemplate restTemplate) {
        try {
            Company[] companiesArray = restTemplate.getForObject(API_URL, Company[].class);
            List<Company> companies = Arrays.asList(companiesArray);
            System.out.println("\nCompany List:");
            System.out.printf("%-5s %-20s %-20s %-20s %-20s %-20s\n", "ID", "Name", "Country", "Timestamp", "Type", "VAT");
            System.out.println("------------------------------------------------------------------------------------------------------");
            for (Company company : companies) {
                System.out.printf("%-5d %-20s %-20s %-20s %-20s %-20s\n", company.getId(), company.getName(), company.getCountry(), company.getTimestamp(), company.getType(), company.getVat());
            }
        } catch (Exception e) {
            System.out.println("Error fetching companies: " + e.getMessage());
        }
    }

    //ADD NEW COMPANY
    public static void addNewCompany(RestTemplate restTemplate, Scanner scanner) {
        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Country: ");
            String country = scanner.nextLine();
            System.out.print("Enter Timestamp: ");
            String timestamp = scanner.nextLine();
            System.out.print("Enter Type: ");
            String type = scanner.nextLine();
            System.out.print("Enter VAT: ");
            String vat = scanner.nextLine();

            Company newCompany = new Company();
            newCompany.setName(name);
            newCompany.setCountry(country);
            newCompany.setTimestamp(timestamp);
            newCompany.setType(type);
            newCompany.setVat(vat);

            String response = restTemplate.postForObject(SAVE_COMPANY_URL, newCompany, String.class);
            System.out.println(response);
        } catch (Exception e) {
            System.out.println("Error adding company: " + e.getMessage());
        }
    }

    //UPDATE COMPANY
    public static void updateCompany(RestTemplate restTemplate, Scanner scanner) {
        try {
            System.out.println("What's the ID of the Company you want to update?");
            long companyId = Long.parseLong(scanner.nextLine());

            System.out.println("Enter new name:");
            String newName = scanner.nextLine();
            System.out.println("Enter new country:");
            String newCountry = scanner.nextLine();
            System.out.println("Enter new timestamp:");
            String newTimestamp = scanner.nextLine();
            System.out.println("Enter new type:");
            String newType = scanner.nextLine();
            System.out.println("Enter new VAT:");
            String newVat = scanner.nextLine();

            Company updatedCompany = new Company(companyId, newName, newCountry, newTimestamp, newType, newVat);
            restTemplate.put(UPDATE_COMPANY_URL, updatedCompany, companyId);
            System.out.println("\nCompany with ID " + companyId + " has been updated.");

        } catch (Exception e) {
            // Handle errors (e.g., invalid input, server issues)
            System.out.println("Error occurred while updating user: " + e.getMessage());
        }
    }

    //DELETE COMPANY
    public static void deleteCompany(RestTemplate restTemplate, Scanner scanner) {
        try {
            System.out.println("What's the ID of the Company you want to delete?");
            String input = scanner.nextLine();
            restTemplate.delete(DELETE_COMPANY_URL, input);
            System.out.println("\nCompany with ID " + input + " has been deleted.");
        } catch (Exception e) {
            System.out.println("Error adding company: " + e.getMessage());
        }
    }
}
