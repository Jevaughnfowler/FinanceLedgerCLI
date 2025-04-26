package com.pluralsight;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HomeScreen();
    }

    private static void HomeScreen(){
        String homeScreenPrompt = "================================" +
                "\nWelcome To The Accounting Ledger" +
                "\n================================" +
                "\n(D) Add Deposit" +
                "\n(P) Make Deposit (Debit)" +
                "\n(L) Ledger" +
                "\n(X) Exit" +
                "\nPlease Select An option";

        int option;

        do {
            System.out.println(homeScreenPrompt);
            option = scanner.nextInt();
            scanner.nextLine();
        }while (option != 0);
    }
}