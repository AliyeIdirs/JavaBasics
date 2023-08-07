package com.unitedcoder.collectiondatastructure;

public class ArrayDemo2 {
    public static void main(String[] args) {
        int[] arr= new int[]{20,40,10,45,43,78,75,45,23,32};
        int[] arr1={3,5,6,8,9,23,89,0};

        System.out.println(arr[3]);
        System.out.println(arr.length);
        int sum=0;
        for (int a:arr){
            sum+=a;
        }
        System.out.println(sum);

        System.out.println(arr1.length);
        System.out.println(arr1[5]);
    }
}
