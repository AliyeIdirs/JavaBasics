package com.unitedcoder.homework.basichomeworks;

import java.util.Scanner;

public class Week6Day3ScannerObject {
    public static void main(String[] args) {
        /*In the Java Scanner Object Code Project, you will write a java code that will print out a person's full home address.
        You will ask following questions;
        What is your name?
        What is your house street address?
        What is the name of the city?
        What is the state?
        After all the above questions are answered, you need to print out the full address?*/
        Scanner input=new Scanner(System.in);
        System.out.println("What is your name?");
        String name=input.nextLine();
        System.out.println("My name is " +name);

        System.out.println("What is your house street address?");
        String address=input.nextLine();
        System.out.println("My house street address is " + address);

        System.out.println("What is the name of the city?");
        String city=input.nextLine();
        System.out.println("My city name is "+ city);

        System.out.println("What is the state?");
        String state=input.nextLine();
        System.out.println("The state name is "+ state);

        System.out.printf("The full address is %s %s %s%n",address,city,state);





    }
}
