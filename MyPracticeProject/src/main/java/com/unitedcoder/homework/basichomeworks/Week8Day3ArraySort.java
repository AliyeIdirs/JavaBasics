package com.unitedcoder.homework.basichomeworks;

import java.sql.Array;
import java.util.*;

public class Week8Day3ArraySort {
    public static void main(String[] args) {
        /*
        Write a Java program to the following requirements.

        Generate 10 random numbers from 10 to 100;
        Assign the numbers to an array
        Sort the numbers in the ascending order and print out
        Sort the numbers in the descending order and print out
         */

        int[] array=new int[10];
        for(int i=0; i<10;i++) {
            Random random = new Random();
            int numbers = random.nextInt(100) + 10;
            array[i]=numbers;
        }
        System.out.println(Arrays.toString(array));
        for(int i=0; i< array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int tempValue=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tempValue;
                }
            }
        }
        System.out.println("Ascending Order: "+Arrays.toString(array));

        for(int i=0; i<array.length-1; i++){
            for(int j=0; j<array.length-1-i; j++){
                if(array[j]<array[j+1]){
                    int plate=array[j];
                    array[j]=array[j+1];
                    array[j+1]=plate;
                }
            }
        }
        System.out.println("Descending Order: "+Arrays.toString(array));
    }
}
