package com.unitedcoder.collectiondatastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] a={20, 10, 5, 30, 25, 70, 55, 90, 77, 0,60};  //{10 5 20 25 30 55 70 77 0 60 90}
        for (int i=0; i<a.length-1; i++){                   //{5 10 20 25 30 55 70 0 60 77}
            for (int j=0; j<a.length-1-i; j++){             //{5 10 20 25 30 55 0 60 70}
                if (a[j] > a[j+1]){                         //{5 10 20 25 30 0 55 60}
                    int tempValue= a[j];                    //{5 10 20 25 0 30 55}
                    a[j] =a[j+1];                           //{5 10 20 0 25 30}
                    a[j+1]=tempValue;                       //{5 10 0 20 25}
                }                                           //{5 0 10 20}
            }                                               //{0 5 10}

        }
        System.out.println(Arrays.toString(a));
        //Bubble sort with stream
        Arrays.stream(a).sorted().forEach(System.out::println);

        //find max and min number
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

        //Max with stream
        numberArrayList.stream().max(Comparator.comparing(i -> i)).ifPresent(System.out::println);

        System.out.println("---Print Min Number---");
        int minNumber=numberArrayList.get(0);
        for(int i=0; i<numberArrayList.size(); i++){
            int nextNumber=numberArrayList.get(i);
            if(nextNumber<minNumber)
                minNumber=nextNumber;
        }
        System.out.println("Min number is: "+minNumber);
        //Min with stream
        numberArrayList.stream().min(Comparator.comparing(integer -> integer)).ifPresent(System.out::println);
    }
}
