package com.unitedcoder.javabasic;

import java.sql.SQLOutput;

public class LoopStatement_DoWhile {
    public static void main(String[] args) {
        //do while loop example 1
        //you want to execute the body of a loop at least once and perform the loop test after the body execution
        double balance = 1000;
        double targetBalance = 10000;
        int years = 0;
        int rate = 5;
        do {
            years++;
            double interest = balance * rate / 100;
            balance = balance + interest;
        }
        while (balance < targetBalance);
        System.out.println("Example 1");
        System.out.println("Final balance: " + balance);
        System.out.println("Total years: " + years);
        System.out.println("*************************");
        System.out.println("Example 2");

        //do while loop example 2
        int i =100;
        int n=0;
        int j=0;
        do {
            n++;
            i =i/2;
            System.out.println("i="+i);
        }
        while (i> 1);
        System.out.printf("Divide number 100 by %d times until the number is less than or equal to 1%n",n);
    }
}
