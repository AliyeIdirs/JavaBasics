package com.unitedcoder.conditions;

import java.util.Scanner;

public class ConditionalStatementDemo2 {
    public static void main(String[] args) {
        Scanner number= new Scanner(System.in);
        System.out.println("Welcome to the Game!!!");
        System.out.println("Please enter your age:");
        int age=number.nextInt();
        if (age >18) {
            System.out.print("Congratulations!!! You can continue with your game!"); //if block
        } else {
            System.out.print("Ooops!!! You are not qualified for this game :("); //else block
        }
    }
}
