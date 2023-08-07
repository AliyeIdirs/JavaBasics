package com.unitedcoder.collectiondatastructure;

import java.util.Arrays;

public class CharArrayDemo {
    public static void main(String[] args) {
        String name="Aliye";
        char[] c=new char[name.length()];
        for (int i=0; i<name.length(); i++){
            c[i]=name.charAt(i); //split each char of a string
        }
        System.out.println(Arrays.toString(c));
    }
}
