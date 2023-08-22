package com.unitedcoder.loops;

public class ForLoopDemo3 {
    public static void main(String[] args) {
        //Find final balance
        int rate =5;
        double balance=1000;
        int year =10;
        for (int i=1; i<=year; i++){
            double interest=balance*rate/100;
            balance= balance+interest;
            System.out.printf("%d Year Balance %f%n",i,balance);
        }
        System.out.println("Final balance is "+balance);
    }
}
