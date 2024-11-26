package com.joris.potomalaka.service;

import com.joris.potomalaka.models.Invoice;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InvoiceService {
    private static final String API_URL = "http://localhost:8080/invoices";
    private static final String SAVE_INVOICE_URL = "http://localhost:8080/save-invoice";
    private static final String DELETE_INVOICE_URL = "http://localhost:8080/delete/invoice/{Id}";
    private static final String UPDATE_INVOICE_URL = "http://localhost:8080/update/invoice/{Id}";

    //VIEW ALL INVOICES
    public static void viewAllInvoices(RestTemplate restTemplate) {
        try {
            Invoice[] invoicesArray = restTemplate.getForObject(API_URL, Invoice[].class);
            List<Invoice> invoices = Arrays.asList(invoicesArray);
            System.out.println("\nInvoice List:");
            System.out.printf("%-5s %-20s %-10s %-20s %-20s %-20s %-20s\n", "ID", "Invoice number", "Amount", "Invoice date", "Invoice Company ID", "Invoice Contact ID", "Timestamp");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
            for (Invoice invoice : invoices) {
                System.out.printf("%-5s %-20s %-10s %-20s %-20s %-20s %-20s\n", invoice.getId(), invoice.getInvoiceNumber(), invoice.getAmount(), invoice.getInvoiceDate(), invoice.getInvoiceCompanyId(), invoice.getInvoiceContactId(), invoice.getTimestamp());
            }
        } catch (Exception e) {
            System.out.println("Error fetching users: " + e.getMessage());
        }
    }

    //ADD NEW INVOICE
    public static void addNewInvoice(RestTemplate restTemplate, Scanner scanner) {
        try {
            System.out.print("Enter Invoice Number: ");
            String invoiceNumber = scanner.nextLine();
            System.out.print("Enter Amount: ");
            int amount = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Invoice Date: ");
            String invoiceDate = scanner.nextLine();
            System.out.print("Enter Invoice Company ID: ");
            long invoiceCompanyId = Long.parseLong(scanner.nextLine());
            System.out.print("Enter Invoice Contact ID: ");
            long invoiceContactId = Long.parseLong(scanner.nextLine());
            System.out.print("Enter Timestamp: ");
            String timestamp = scanner.nextLine();

            Invoice newInvoice = new Invoice();
            newInvoice.setInvoiceNumber(invoiceNumber);
            newInvoice.setAmount(amount);
            newInvoice.setInvoiceDate(invoiceDate);
            newInvoice.setInvoiceCompanyId(invoiceCompanyId);
            newInvoice.setInvoiceContactId(invoiceContactId);
            newInvoice.setTimestamp(timestamp);

            String response = restTemplate.postForObject(SAVE_INVOICE_URL, newInvoice, String.class);
            System.out.println(response);
        } catch (Exception e) {
            System.out.println("Error adding invoice: " + e.getMessage());
        }
    }

    //UPDATE INVOICE
    public static void updateInvoice(RestTemplate restTemplate, Scanner scanner) {
        try {
            System.out.println("What's the ID of the Invoice you want to update?");
            long invoiceId = Long.parseLong(scanner.nextLine());

            System.out.println("Enter new Invoice Number:");
            String newInvoiceNumber = scanner.nextLine();
            System.out.println("Enter new Amount:");
            int newAmount = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter new Invoice Date:");
            String newInvoiceDate = scanner.nextLine();
            System.out.println("Enter new Invoice Company ID:");
            long newInvoiceCompanyId = Long.parseLong(scanner.nextLine());
            System.out.println("Enter new Invoice Contact ID:");
            long newInvoiceContactId = Long.parseLong(scanner.nextLine());
            System.out.println("Enter new Timestamp");
            String newTimestamp = scanner.nextLine();

            Invoice updatedInvoice = new Invoice(invoiceId, newInvoiceNumber, newAmount, newInvoiceDate, newInvoiceCompanyId, newInvoiceContactId, newTimestamp);
            restTemplate.put(UPDATE_INVOICE_URL, updatedInvoice, invoiceId);
            System.out.println("\nInvoice with ID " + invoiceId + " has been updated.");

        } catch (Exception e) {
            System.out.println("Error occurred while updating invoice: " + e.getMessage());
        }
    }

    //DELETE INVOICE
    public static void deleteInvoice(RestTemplate restTemplate, Scanner scanner) {
        try {
            System.out.println("What's the ID of the Invoice you want to delete?");
            String input = scanner.nextLine();
            restTemplate.delete(DELETE_INVOICE_URL, input);
            System.out.println("\nInvoice with ID " + input + " has been deleted.");
        } catch (Exception e) {
            System.out.println("Error adding invoice: " + e.getMessage());
        }
    }
}
