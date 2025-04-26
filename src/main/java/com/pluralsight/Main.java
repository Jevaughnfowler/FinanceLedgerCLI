package com.pluralsight;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HomeScreen();
    }

    //This is my user interface where it Prompt the user for an response to select from the following option.
    //

    private static void HomeScreen(){
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

            switch (option){
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

        }while (option != (""));
    }

    private static void AddDeposit(){

        System.out.println("Would you Like to Make a Deposit");
        System.out.println("Please Enter your information below");

        scanner.nextLine();
        //we are gonna display steps for them to add there info
        //and make sure it is save to the csv file


    }

    private static void MakePayment(){
        System.out.println("Please Make A payment (Debit Only)");
        //work are going to prompt the user to enter there information
        //and we are gonna make sure it is saved to csv file
    }

    private static void EnterLedger(){
        // system print out the ledger when they enter here
        // display all enter by newest first
        //

    }


    //X- to exit the app need to come back to this point
}


