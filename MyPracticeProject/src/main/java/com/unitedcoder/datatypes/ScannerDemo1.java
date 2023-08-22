package com.unitedcoder.datatypes;

import java.util.Scanner;

public class ScannerDemo1 {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        System.out.println("Please enter your school name: ");
        String schoolName=input.nextLine();
        System.out.println("Please enter your school address:");
        String address=input.nextLine();
        System.out.println("Please enter your school zipcode");
        String zipCode=input.nextLine();
        System.out.printf("Your school full address is %s %s %s", schoolName, address,zipCode);


    }


}
