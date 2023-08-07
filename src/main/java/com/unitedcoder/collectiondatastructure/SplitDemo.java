package com.unitedcoder.collectiondatastructure;

import java.util.Arrays;

public class SplitDemo {
    public static void main(String[] args) {
        String school="United_Coder";
        String s="Hello, world";

        String[] array1=school.split("_");
        for (String a:array1){
        }
        System.out.println(Arrays.toString(array1));
        String[] array2=s.split(",");
        for(String b:array2){

        }
        System.out.println(Arrays.toString(array2));


    }
}
