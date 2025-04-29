package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

        System.out.println("\n All Transactions ");
        for (String line : lines){
            String[] parts = line.split("\\|");
            System.out.printf("Date: %s | Time: %s | Vendor: %s | Amount : $%.2f\n",parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]));
        }
        System.out.println("---------------\n");
    }
}


