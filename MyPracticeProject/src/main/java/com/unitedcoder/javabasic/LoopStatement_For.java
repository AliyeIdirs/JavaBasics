package com.unitedcoder.javabasic;

public class LoopStatement_For {
    public static void main(String[] args)
    {
        //for loop
        //example 1 (find the sum of the number from 1 to 100
        int sum=0;
        for (int i=1; i<=100;i++)
        {
            sum=sum+i;
        }
        System.out.println("Example 1");
        System.out.println("Total sum:" +sum);
        System.out.println("*******************");
        System.out.println("Example 2");

        //example 2 (find final balance)
        int rate=5;
        double balance=1000;
        int year=10;
        for (int i=1; i<=year; i++)
        {
            double interest=balance*rate/100;
            balance=balance+interest;

            System.out.printf("%d Year Balance %f%n",i,balance);
        }
        System.out.println("Final balance is " +balance);
    }
}
