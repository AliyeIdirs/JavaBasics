package com.unitedcoder.conditions;

import java.util.Scanner;

public class ConditionalStatementDemo1 {
    public static void main(String[] args) {
        Scanner number= new Scanner(System.in);
        System.out.println("enter number1:");
        int number1=number.nextInt();
        System.out.println("enter number2:");
        int number2=number.nextInt();

        if (number1>number2) {
            System.out.printf("%d is greater than %d",number1,number2); //if block
        } else {
            System.out.printf("%d is less than %d",number1,number2); //else block
        }
    }
}
