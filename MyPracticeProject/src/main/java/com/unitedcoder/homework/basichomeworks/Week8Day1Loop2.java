package com.unitedcoder.homework.basichomeworks;

import java.util.Random;

public class Week8Day1Loop2 {
    public static void main(String[] args) {
        //Write a Java program that prints out the sum and average of five random numbers from 1 to 50.
        //Note: you can use Java Math.random() or Random object.
        double sum=0;
        int i;
        double average=0;
        for (i=1; i<=5; i++ ){
            Random random= new Random();
            int x= random.nextInt(50)+1;
            sum +=x;
            average =(sum/i);
            System.out.print(x +" ");

        }
        System.out.println("\nSum of random x's is: "+ sum);
        System.out.print("Average is " +average);
    }
}
