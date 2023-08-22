package com.unitedcoder.javabasic;

import java.util.Scanner;

public class DecisionMakingDemo1 {
    public static void main(String[] args) {
        // if else statement always uses with relational operators: ==, !=, >, >=, <, <=
        //define a scanner object to input withdraw amount
        System.out.println("Exmaple 1 for conditioal statement");
        Scanner inputAmount= new Scanner(System.in);
        System.out.println("Enter the amount to withdraw: ");
        int withdrawAmount=inputAmount.nextInt();
        System.out.println("You entered " +withdrawAmount);

        //Balance
        int accountBalance=10000;
        if (withdrawAmount <= accountBalance ) {
            accountBalance=accountBalance-withdrawAmount;
            System.out.println("Your balance is " +accountBalance);
        } else {
            System.out.println("Please enter an amount less than your account balance");
            System.out.println("Your account balance is " + accountBalance);

        }

        //use conditional operators ?:
        System.out.println("Exmaple 2 for conditional statement");
        int accountBalance2= 5000;
        System.out.println("Your initial balance is: " +accountBalance2);
        Scanner inputAmount2= new Scanner(System.in);
        System.out.println("Enter the amount to withdraw:");
        int withdrawAmount2=inputAmount2.nextInt();
        System.out.println("You entered " +withdrawAmount2);

        //Balance
        int finalBalance= accountBalance2 -withdrawAmount2;
        accountBalance2 = withdrawAmount2 <= accountBalance2 ? finalBalance: accountBalance2;
        System.out.printf("Your balance is %d%n",accountBalance2);

    }
}
