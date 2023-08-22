package com.unitedcoder.javabasic;

import java.util.Scanner;
public class InputExample {
    public static void main(String [] args){
        //Define a Scanner object
        Scanner inputName =new Scanner(System.in);
        System.out.println("What is your name?");
        String nameValue=inputName.next(); //this will read only the first word
        //String nameValue=inputName.nextLine(); this will read the whole line
        System.out.println("Your name is " +nameValue);
        System.out.printf("Your name is %s%n",nameValue);

        //Define another scanner object
        System.out.println("What is the value of the expression 5*4 ?");
        Scanner inputValue=new Scanner(System.in);
        int value=inputValue.nextInt();
        System.out.println("The value of 5*4 is " +value);

        //More example
        System.out.println("How old are you?");
        Scanner answer=new Scanner(System.in);
        int age=answer.nextInt();
        System.out.printf("I am %s years old%n",age);

        System.out.println("What is your husband's name?");
        Scanner input1=new Scanner(System.in);
        String output1=input1.nextLine();
        System.out.println("My husband's name is " +output1);

        System.out.println("What brand of mobile phone do you use");
        Scanner phoneBrand=new Scanner(System.in);
        String answer1=phoneBrand.next();
        System.out.println("I use " + answer1);

        System.out.println("What is your phone number?");
        Scanner phoneNumber=new Scanner(System.in);
        String number=phoneNumber.next();
        System.out.println("My phone number is "+ number);

    }
}
