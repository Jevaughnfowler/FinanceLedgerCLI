package com.pluralsight;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Console {

    Scanner scanner = new Scanner(System.in);

    private Transaction transaction;

    public int promptForInt(String prompt){
        boolean hasResult = false;
        int result = -1;
        while(!hasResult) {
            try{
                System.out.print(prompt);
                result = scanner.nextInt();
                scanner.nextLine();
                hasResult = true;

            } catch (Exception e) {
                System.out.println("Invalid entry, please try again!");
                scanner.next();
            }
        }

        return result;

    }

//need to make customize this console to make it interact with the information that the user enter
// in order to make the file save to the csv file
    public void saveTransaction () {
        try (FileWriter writer = new FileWriter("transaction.csv",true)){
            writer.write(transaction.toString() + "\n");
        }catch (IOException e){
            System.out.println("Error " + e.getMessage());

        }
    }

    public String promptForString(String prompt){
        System.out.print(prompt);
        return scanner.nextLine();
    }

}

