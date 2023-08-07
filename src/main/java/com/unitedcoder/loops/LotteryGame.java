package com.unitedcoder.loops;

import java.util.Random;
import java.util.Scanner;

public class LotteryGame {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int winCounts=0;
        int totalGame=10;
        for (int i=1; i<=totalGame; i++){
            System.out.println("Enter your lottery number: ");
            Random random= new Random();
            int lotteryNumber= random.nextInt(10);
            int yourNumber=scan.nextInt();
            System.out.printf("Lottery Number =%d, Your number =%d%n",lotteryNumber,yourNumber);
            if (lotteryNumber==yourNumber){
                System.out.println("You won the lottery");
                winCounts++;
            } else {
                System.out.println("Try again, you lost");
            }
            System.out.printf("Remaining game count: %d%n",20-i);
        }
        System.out.println("Your total win is " +winCounts);
    }
}
