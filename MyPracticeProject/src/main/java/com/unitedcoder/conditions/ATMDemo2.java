package com.unitedcoder.conditions;

import java.util.Scanner;

public class ATMDemo2 {
    public static void main(String[] args) {
        int correctPin=1234;
        //Pin number
        Scanner input=new Scanner(System.in);
        System.out.println("Please enter your PIN number:");
        int pin=input.nextInt();
        if (String.valueOf(pin).length()==4 && pin==correctPin) {
            System.out.println("Correct PIN length.");
            System.out.println("Your account number is 23455656");
            System.out.println("Your account balance is 100000$");
        }else {
            System.out.println("You entered wrong PIN number!");
            System.out.println("Please try again with correct PIN number");
        }


    }
}
