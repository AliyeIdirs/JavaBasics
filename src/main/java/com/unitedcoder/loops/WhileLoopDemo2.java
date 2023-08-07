package com.unitedcoder.loops;

import java.util.Locale;
import java.util.Scanner;

public class WhileLoopDemo2 {
    public static void main(String[] args) {
        // Scanner 0
        Scanner scanner=new Scanner(System.in);
        int positiveNumberCounts=0;
        int negativeNumberCounts=0;
        while(true){
            int number = scanner.nextInt();
            if (number>0){
                positiveNumberCounts++;

            } else if (number<0) {
                negativeNumberCounts++;
            }
            else {
                break;
            }
        }
        System.out.println("Positive Numbers: " +positiveNumberCounts);
        System.out.println("Negative Numbers: " +negativeNumberCounts);
    }
}
