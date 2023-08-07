package com.unitedcoder.javabasic;
import java.util.Scanner;
public class NestedConditionalStatement {
    public static void main(String[] args)
    {
        //nested conditional statement
        //define a scanner object to input a number
        Scanner inputNumber=new Scanner (System.in);
        System.out.println("Enter a number: ");
        int number=inputNumber.nextInt();
        if (number >0)
        {
            if(number%2==0)
            {
                System.out.println("You entered a positive even number");

            }
            else
            {
                System.out.println("You entered positive odd number");
            }

        }
        else
            System.out.println("Please enter a positive number");
    }
}

