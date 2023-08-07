package com.unitedcoder.collectiondatastructure;

import java.sql.Array;
import java.util.Arrays;

public class ArrayMethods {
    public static void main(String[] args) {
        int[] arr1={98,67,44,23,10};
        int[] arr2={78,90,34,80,45};
        int[] arr3=Arrays.copyOf(arr1,5); //copy an array

        //compare two arrays
        boolean result1= Arrays.equals(arr1,arr2); //false
        boolean result2= Arrays.equals(arr1,arr3); //true
        System.out.println(result1);
        System.out.println(result2);
        //fill array with the given value
        Arrays.fill(arr1,65);
        System.out.println(Arrays.toString(arr1)); //[65, 65, 65, 65, 65]

        System.out.println(Arrays.toString(arr3)); //{98,67,44,23,10}

        //copy a new array
        int[] arr4= new int[arr2.length];
        System.arraycopy(arr2, 0, arr4, 0, arr2.length);
        System.out.println(Arrays.toString(arr4)); //{78,90,34,80,45}





    }
}
