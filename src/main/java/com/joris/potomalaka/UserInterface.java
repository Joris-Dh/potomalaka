package com.joris.potomalaka;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        System.out.println();
        System.out.println();
        System.out.println("Welcome to our database! What info would you like to access?");
        while (true) {
            System.out.println("Command:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Companies")) {
                System.out.println("This is still work in progress!");

            } else if (input.equalsIgnoreCase("Exit")){
                System.out.println("Thanks for your visit, bye!");
                break;

            } else {
                System.out.println("No valid command");
            }
        }
    }
}
