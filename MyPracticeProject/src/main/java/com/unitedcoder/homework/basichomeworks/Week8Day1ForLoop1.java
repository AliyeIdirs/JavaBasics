package com.unitedcoder.homework.basichomeworks;

public class Week8Day1ForLoop1 {
    public static void main(String[] args) {
        //Write a Java program that prints out the square of even numbers ranging from 2 to 20.
        // After finishing your code, create a Jar file and execute in your OS command prompt or terminal.
        //For example:
        //Number  Square
        //2                   4
        //4                   16
        //6                    36
        //8                    64
        System.out.println("Number Square");
        for (int i=2; i<=20; i++){
            if (i%2==0) {
                double square = Math.pow(i, 2);
                System.out.printf("%-15d %.0f%n", i, square);
            }
        }
        System.out.println();
    }
}
