package com.pluralsight;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HomeScreen();
    }

    //This is my user interface where it Prompt the user for an response to select from the following option.
    //

    private static void HomeScreen() {
        String homeScreenPrompt = "===================================" +
                "\n Welcome To The Accounting Ledger" +
                "\n===================================" +
                "\n(D) Add Deposit" +
                "\n(P) Make Deposit (Debit)" +
                "\n(L) Ledger" +
                "\n(X) Exit" +
                "\nPlease Select An option";

        String option;

        do {
            System.out.println(homeScreenPrompt);
            option = scanner.nextLine().toUpperCase().trim();

            switch (option) {
                case ("D"):
                    AddDeposit();
                    break;
                case ("P"):
                    MakePayment();
                    break;
                case ("L"):
                    EnterLedger();
                    break;
                case ("X"):
                    System.out.println("Exit The Application");
                    break;
                default:
                    System.out.println("Invalid, Please Try Again");


            }

        } while (!option.equals("X"));
    }

    private static void AddDeposit() {

        Console console = new Console();

        System.out.println("\nWould you like to make a Deposit?");
        System.out.println("If yes, please enter your information below.");
        System.out.println("Otherwise, type (X) to cancel and return to Home.\n");

        // give them a chance to cancel
        String cancel = console.promptForString("Press ENTER to continue or X to cancel: ");
        if (cancel.equalsIgnoreCase("X")) {
            System.out.println("Deposit cancelled. Returning to Home Screen...");
            return; // exit the method
        }

        // 1. Prompt for all deposit details
        String description = console.promptForString("Enter a description: ");
        String vendor = console.promptForString("Enter the vendor name: ");
        double amount = console.promptForInt("Enter the amount: ");

        // 2. Create a new Transaction object
        Transaction transaction = new Transaction(
                java.time.LocalDate.now(),
                java.time.LocalTime.now(),
                description,
                vendor,
                amount
        );

        // 3. Save transaction to transactions.csv
        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter("transactions.csv", true))) {
            writer.write(transaction.toCSVString() + "\n");
            System.out.println("✅ Deposit saved successfully!");
        } catch (Exception e) {
            System.out.println("⚠️ Error saving the deposit: " + e.getMessage());

        }


    }
    private static void MakePayment () {
        System.out.println("Please Make A payment (Debit Only)");
        //work are going to prompt the user to enter there information
        //and we are gonna make sure it is saved to csv file
    }

    private static void EnterLedger () {
        // system print out the ledger when they enter here
        // display all enter by newest first
        //

    }
}

