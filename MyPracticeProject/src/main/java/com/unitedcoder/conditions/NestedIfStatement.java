package com.unitedcoder.conditions;

import java.util.Scanner;

public class NestedIfStatement {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int number=input.nextInt();
        if (number > 0) {
            if(number %2 ==0 ) {
                System.out.println("You entered a positive even number");

            } else {
                System.out.println("You entered a positive odd number");
            }
        } else {
            System.out.println("Please enter a positive number");
        }
    }
}
