package com.unitedcoder.selfproject;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinValueInArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter an array length:");
        int arrayLength = scan.nextInt();
        int[] array = new int[arrayLength];
        for (int i=0; i<array.length;i++){
            array[i] = (int) (Math.random() * 100 + 1);
        }
        System.out.println(Arrays.toString(array));

        int minValue = array[0];
        for (int i = 0; i < arrayLength; i++) {
            if (array[i]<minValue) {
                minValue = array[i];
            }
        }
        System.out.println("Minimum value of array is: "+minValue);
    }
}

