package com.unitedcoder.javabasic;

public class LoopStatement_While {
    public static void main(String [] args)
    {
        //While loop example1
        //keep executing the statement while the condition is true
        double balance=1000;
        double targetBalance=10000;
        int years=0;
        int rate=5;
        while(balance<targetBalance)
        {
            years++;
            double interest=balance*rate/100;
            balance=balance+interest;
        }
        System.out.println("Example 1");
        System.out.println("Final balance: "+balance);
        System.out.println("Total years: "+years);
        System.out.println("**********************");
        System.out.println("Example 2");

        //while loop example2
        int i=0;
        int sum=0;
        while(i<10)
        {
            i++;
            sum=sum+i;
        }
        System.out.printf("Sum of number 0 to %d is %d%n",i,sum);
    }
}
