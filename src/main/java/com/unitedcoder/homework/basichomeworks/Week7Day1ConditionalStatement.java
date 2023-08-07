package com.unitedcoder.homework.basichomeworks;

import java.util.Scanner;

public class Week7Day1ConditionalStatement {
    public static void main(String[] args) {
/*      Under the main method, you need to write these expressions in a. b and c.
        IntelliJ IDEA will display some errors. You need to fix the errors by adding some codes
        so that your main method should run without any error. give demo in the classroom.
        a.
        if(x && y==0) {x=2; y=2;}
        b
        if(1<=x <=100)  System.out.println(x);
        c
        if(!s.equals("nickels") || !s.equals("pennies") || !s.equals("dimes")
        System.out.print("Money input error)
        */
        Scanner input= new Scanner(System.in);
        System.out.println("Please choose statement: \na\nb\nc");
        char statement=input.next().charAt(0);
        System.out.println("You chose "+statement);
        switch (statement){
            case 'a':
                int x=2; int y=2;
                if (x ==0 && y==0)
                    System.out.println("wrong statement!");
                else {
                    System.out.printf("x = %d\ny = %d%n",x,y);
                }
                break;
            case 'b':
                x=15;
                if (x>= 1 && x <=100)
                    System.out.println(x);
                break;
            case 'c':
                String s="Nickles";
                if (!s.equals("nickels") || !s.equals("pennies") || !s.equals("dimes"))
                    System.out.println("Monkey input error");
                break;
            default:
                System.out.println("Please choose correct char!");
        }
    }
}
