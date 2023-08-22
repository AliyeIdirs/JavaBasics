package com.unitedcoder.collectiondatastructure;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FindMaxValueInArray {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.println("Please enter an array length:");
        int arrayLength=scan.nextInt();
        int[] array= new int[arrayLength];
        for (int i=0; i<arrayLength; i++){
            array[i]= RandomUtils.nextInt(i,100);
        }
        System.out.println(Arrays.toString(array));
        System.out.println((Arrays.stream(array).max()));

        //another solution
        int[] array2= new int[arrayLength];
        int maxValue=0;
        for (int i=0; i<arrayLength; i++){
            array2[i]= (int)(Math.random()*100+1);
            if(array2[i]>maxValue){
                maxValue=array2[i];
            }
        }
        System.out.println(Arrays.toString(array2));
        System.out.println("Maximum value of array is: "+maxValue);

        Integer[] evenNumber= new Integer[]{2,4,6,8,8,2,8,10};
        ArrayList<Integer> numberArrayList=new ArrayList<>();
        Collections.addAll(numberArrayList,evenNumber);
        System.out.println("---Print Max Number---");
        int maxNumber=numberArrayList.get(0);
        for(int j=1; j<numberArrayList.size();j++){
            int nextNumber=numberArrayList.get(j);
            if(nextNumber>maxNumber)
                maxNumber=nextNumber;
        }
        System.out.println("Max number is: "+maxNumber);
        System.out.println(numberArrayList);
    }
}
