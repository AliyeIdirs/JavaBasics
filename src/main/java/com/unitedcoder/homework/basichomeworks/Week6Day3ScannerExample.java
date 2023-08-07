package com.unitedcoder.homework.basichomeworks;
import java.util.Scanner;
public class Week6Day3ScannerExample {
    public static void main(String[] args){

        Scanner number=new Scanner(System.in);
        System.out.print("Please enter a number: ");
        if(number.nextInt()%2==0)
            System.out.println("You entered an even number");
        else
            System.out.println("You entered an odd number");
    }

}
