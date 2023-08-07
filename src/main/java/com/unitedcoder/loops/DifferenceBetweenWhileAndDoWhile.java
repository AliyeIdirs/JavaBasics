package com.unitedcoder.loops;

public class DifferenceBetweenWhileAndDoWhile {
    public static void main(String[] args) {
        int number1= 100;
        while (number1>100){
            System.out.println("While Block");
            number1 --;
        }
        int number2=0;
        do {
            System.out.println("Do While Block");
            number2 --;
        } while (number2>100);
    }
}
