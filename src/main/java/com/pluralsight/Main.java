package com.pluralsight;

import java.util.ArrayList;
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
            return;
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
        LedgerHelp.saveTransaction(transaction);

        //improve later make it as if you want to quit deposit or add another

    }


    private static void MakePayment () {

        Console console = new Console();

        System.out.println("\nWould you to make a Payment?");
        System.out.println("If yes, please enter your information below.");
        System.out.println("Otherwise, type (X) to cancel and return to Home.\n");

        String cancel = console.promptForString("Press ENTER to continue or X to cancel: ");
        if (cancel.equalsIgnoreCase("X")){
            System.out.println("Payment cancelled. Returning to home screen");
            return;
        }

        String description = console.promptForString("Enter a description: ");
        String vendor = console.promptForString("Enter the vendor name: ");


        double amount = 0;
        while (amount <= 0) {
            amount = console.promptForInt("Enter the amount: ");
            if (amount <= 0){
                System.out.println("⚠️ Invalid amount. Please try again.");
            }
        }

        amount = -amount;

        Transaction transaction = new Transaction(
                java.time.LocalDate.now(),
                java.time.LocalTime.now(),
                description,
                vendor,
                amount
        );

        // Save transaction to transactions.csv
        LedgerHelp.saveTransaction(transaction);


        //work are going to prompt the user to enter there information
        //and we are gonna make sure it is saved to csv file
    }


    private static void EnterLedger () {

        Console console = new Console();
        String choice;

        System.out.println("Please choose an option: \n" +
                "(A) All\n" +
                "(D) Deposits\n" +
                "(P) Payments\n" +
                "(R) Reports\n" +
                "Otherwise (H) Home");

        choice = console.promptForString("Enter option \n").toUpperCase().trim();

        switch (choice){
            case "A":
                LedgerHelp.showAllTransactions();
                break;
            case "D":
                LedgerHelp.showDepositsOnly();
                break;
            case "P":
                LedgerHelp.showPaymentsOnly();
                break;
            case "R":
                System.out.println("Choose report type: \n" +
                        "(1) Month To Date\n" +
                        "(2) Previous Month\n" +
                        "(3) Year To Date\n" +
                        "(4) Previous Year\n" +
                        "(5) Search by Vendor");
                break;
            case "H":
                System.out.println("Returning Home...");
                break;
            default:
                System.out.println("Invalid, Please try again");

        }


    }
}

