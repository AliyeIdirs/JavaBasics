package com.unitedcoder.selfproject;

import java.util.Scanner;

public class IfElseIfElseStatement {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Please enter your grade:");
        int grade=input.nextInt();
        if (grade >=90)
            System.out.println("Your grade is A");
        else if (grade <90 && grade >=80)
            System.out.println("Your grade is B");
        else if (grade <80 && grade >=70)
            System.out.println("Your grade is C");
        else if(grade <70 && grade >=60)
            System.out.println("Your grade is D");
        else{
            System.out.println("You failed");
        }
    }
}
