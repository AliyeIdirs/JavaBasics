package com.unitedcoder.datatypes;

import java.util.Scanner;

public class ScannerObject {
    public static void main(String[] args) {
        //define scanner object
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter one digit number");
        int x= scanner.nextInt();
        System.out.println("Please enter second digit number");
        int y= scanner.nextInt();
        System.out.printf("Please enter the value of %d +%d\n",x,y);
        int z= scanner.nextInt();
        if (z == x+y){
            System.out.println("Your answer is correct!");
        } else {
            System.out.println("Wrong Answer!!!");
        }
    }
}
