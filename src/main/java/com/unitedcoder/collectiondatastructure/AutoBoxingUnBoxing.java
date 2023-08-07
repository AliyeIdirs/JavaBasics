package com.unitedcoder.collectiondatastructure;

import com.beust.ah.A;

import java.util.ArrayList;

public class AutoBoxingUnBoxing {
    public static void main(String[] args) {
        ArrayList<Integer> intArrayList = new ArrayList<>();
        for (int i=0; i<=10; i++){
            intArrayList.add(Integer.valueOf(i)); //AutoBoxing
        }

        for (int i=0; i<=10; i++){
            System.out.println(i+ "-->" +intArrayList.get(i).intValue()); //Unboxing
        }
    }
}
