package com.unitedcoder.conditions;

import java.util.Scanner;

public class AdvancedSwitchStatement {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("Enter your grade:");
        char gradeLetter=input.next().charAt(0);
        gradeLetter= Character.toUpperCase(gradeLetter);
        System.out.println("You entered: " +gradeLetter);

        switch (gradeLetter){
            case 'A':
            case 'B':
            case 'C':
                System.out.println("Well done!");
                System.out.println("You have a passing grade!");
                break;
            case 'D':
            case 'F':
                System.out.println("Your grade is less than 60");
                System.out.println("You failed!");
                break;
            default:
                System.out.println("Please enter a proper grade letter: A, B, C, D, F");
                break;

        }
    }
}
