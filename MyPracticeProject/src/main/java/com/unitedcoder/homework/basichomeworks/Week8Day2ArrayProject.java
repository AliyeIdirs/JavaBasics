package com.unitedcoder.homework.basichomeworks;


import java.util.Arrays;

public class Week8Day2ArrayProject {
    public static void main(String[] args) {
        /*Write a Java program with the following requirements.
        Write a loop that fills an array  with 30 random numbers between 1 and 100;
        Count all the even numbers and print the total count;
        Count all the odd numbers and print the total count;
        Count all the numbers that are divided by three and print the total count;
        Calculate the sum and average of the 30 random numbers;
        Sort the number with ascending order and print out all the numbers;
        Sort the number with descending order and print out the number;
         */

        int[] arr = new int[30];
        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = (int) (Math.random() * 100 + 1);
        }
        System.out.println("The Original Array is: " + Arrays.toString(arr));
        int evenNumCount = 0;
        int oddNumCount = 0;
        int divisiblethree = 0;
        double totalSum = 0;
        double average = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenNumCount++;
            }

            if (arr[i] % 2 != 0) {
                oddNumCount++;
            }
            if (arr[i] % 3 == 0) {
                divisiblethree++;
            }
            totalSum += i;
            average = totalSum / (30);

            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tempValue = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tempValue;
                }
            }
        }
        System.out.println("Even Number Count:" +evenNumCount);
        System.out.println("Odd Number Count:" +oddNumCount);
        System.out.println("Numbers divisible by 3: " +divisiblethree);
        System.out.println("Total Sum is: "+ totalSum);
        System.out.println("Average is: "+average);
        System.out.println("Ascending Order: "+Arrays.toString(arr));
        for (int i=arr.length-1; i>=0;i--){
            System.out.print(arr[i] +" ");
        }

    }
}
