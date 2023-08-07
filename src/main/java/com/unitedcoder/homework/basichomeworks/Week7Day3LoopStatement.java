package com.unitedcoder.homework.basichomeworks;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

import static com.google.common.math.IntMath.isPrime;

public class Week7Day3LoopStatement {
    public static void main(String[] args) {
        //1. Write a Java program that asks the user to enter an integer from the console and then print
        // out all prime numbers up to that integer. For example, when the user enters 30, the program
        // should print out
        //2,3,5,7,11,13,17,19,23,29
        //Recall that a number is a prime number if it is not divisible by any number except 1 and itself.
        Scanner scan = new Scanner(System.in);
        int num =scan.nextInt();

        //Solution 1
        for(int i=2; i<num; i++){
            boolean isPrime=true;
            for(int j=2; j<i;j++){
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
                System.out.print(i +" ");
        }
        // solution 2
        for (int i = 1; i < num; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

         //Print [] shape
        System.out.println("\nenter second number:");
        int num2=scan.nextInt();
        for(int row= 1; row <= num2; row++){ //1
            for (int column=1; column<= Math.pow(2,row); column++){ // 2 4 8
                System.out.print("[]");
            }
            System.out.println();
        }
    }

}
