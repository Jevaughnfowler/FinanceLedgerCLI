package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LedgerHelp {

    public static void saveTransaction(Transaction transaction) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv", true))) {
            writer.write(transaction.toCSVString() + "\n");
            System.out.println("✅ Transaction saved successfully!");
        } catch (IOException e) {
            System.out.println("⚠️ Error saving transaction: " + e.getMessage());
        }
    }
}