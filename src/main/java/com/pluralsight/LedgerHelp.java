package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class LedgerHelp {

    public static void saveTransaction(Transaction transaction) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv", true))) {
            writer.write(transaction.toCSVString() + "\n");
            System.out.println("✅ Transaction saved successfully!");
        } catch (IOException e) {
            System.out.println("⚠️ Error saving transaction: " + e.getMessage());
        }
    }

//ledger menu option
    public static void showAllTransactions(){
        List<String> lines = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))){
            String line;
            while((line = reader.readLine()) != null){
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error reading transactions: " + e.getMessage());
            return;
        }

        Collections.reverse(lines);

        System.out.println("=========================\n" +
                "  All Transactions \n" +
                "=========================");
        for (String line : lines){
            String[] parts = line.split("\\|");
            System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount : $%.2f\n",
                    parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]));
        }
        System.out.println("-------------------------------------------------------------------------------------------\n");
    }


    public static void showDepositsOnly(){
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error reading transactions: " + e.getMessage());
            return;
        }

        Collections.reverse(lines);

        System.out.println("=================== \n" +
                "    Deposits \n" +
                "===================");
        for (String line : lines) {
            String[] parts = line.split("\\|");
            double amount = Double.parseDouble(parts[4]);
            if (amount > 0) {
                System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: $%.2f\n",
                        parts[0], parts[1], parts[2], parts[3], amount);
            }
        }
        System.out.println("-------------------------------------------------------------------------------------------\n");
    }


    public static void showPaymentsOnly(){
        ArrayList<String> lines = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("transaction.csv"))){
            String line;
            while((line = reader.readLine()) != null){
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error reading transactions: " + e.getMessage());
            return;
        }

        Collections.reverse(lines);

        System.out.println("====================\n" +
                "   Payments   \n" +
                "===================");
        for (String line : lines) {
            String[] parts = line.split("\\|");
            double amount = Double.parseDouble(parts[4]);
            if (amount < 0) {
                System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: $%.2f\n",
                        parts[0], parts[1], parts[2], parts[3], amount);
            }
        }
        System.out.println("-------------------------------------------------------------------------------------------\n");
    }

// Reports menu options
    public static void showMonthToDate(){
        LocalDate today = LocalDate.now();
        List<String> lines = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("transaction.csv"))){
            String line;
            while ((line = reader.readLine()) != null){
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error reading transactions: " + e.getMessage());
            return;
        }

        System.out.println("================\n" +
                "   Month To Date \n" +
                "======================");
        for (String line : lines){
            String[] parts = line.split("\\|");
            LocalDate transactionDate = LocalDate.parse(parts[0]);
            if (transactionDate.getMonth() == today.getMonth() && transactionDate.getYear() == today.getYear()){
                System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: $%.2f\n", parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]));
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------\n");
    }


    public static void showPreviousMonths(){
        LocalDate today = LocalDate.now();
        LocalDate previousMonth = today.minusMonths(1);
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("transaction.csv"))){
            String line;
            while ((line = reader.readLine()) != null){
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error reading transactions: " + e.getMessage());
            return;
        }
        System.out.println("========================\n" +
                "    Previous Month    \n" +
                "================================");
        for(String line : lines){
            String[] parts = line.split("\\|");
            LocalDate transactionDate = LocalDate.parse(parts[0]);
            if (transactionDate.getMonth() == previousMonth.getMonth() && transactionDate.getYear() == previousMonth.getYear());

        }
        System.out.println("-------------------------------------------------------------------------------------------\n");
    }


    public static void showPreviousYear(){
        LocalDate today = LocalDate.now();
        LocalDate previousYear = today.minusYears(1);
        List<String> lines = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("transaction.csv"))){
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error reading transactions: " + e.getMessage());
            return;
        }
        System.out.println("=====================\n" +
                "      Previous Year    \n" +
                "==========================" );
        for(String line : lines) {
            String[] parts = line.split("\\|");
            LocalDate transactionDate = LocalDate.parse(parts[0]);
            if (transactionDate.getYear() == previousYear.getYear()){
                System.out.printf("Date: %s | Time: %s | Vendor: %s | Amount: $%.2f\n", parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]));
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------\n");
    }

    

}


