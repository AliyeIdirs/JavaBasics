package com.unitedcoder.collectiondatastructure;

public class ArrayDemo1 {
    public static void main(String[] args) {
        //integer array, fixed length
        int[] array1= new int[8]; //can store 8 value/element
        array1[0]=10;  array1[1]=25;
        array1[2]=15;  array1[3]=20;
        array1[4]=24;  array1[5]=56;
        array1[6]=98;  array1[7]=46;

        System.out.println(array1[2]);
        System.out.println(array1[5]);
        System.out.println(array1.length);

        for(int i=0; i<array1.length; i++){
            System.out.print(array1[i] +" ");
        }
        //for each loop
        System.out.println();
        for (int a:array1){
            System.out.print(a +" ");
        }
    }
}
