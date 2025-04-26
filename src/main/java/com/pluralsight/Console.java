package com.pluralsight;

import java.util.Scanner;

public class Console {

    Scanner scanner = new Scanner(System.in);

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

    public String promptForString(String prompt){
        System.out.print(prompt);
        return scanner.nextLine();
    }

}

