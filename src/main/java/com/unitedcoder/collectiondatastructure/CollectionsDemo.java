package com.unitedcoder.collectiondatastructure;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsDemo {
    public static void main(String[] args) {

        //Use Collections to find max and min numbers
        int[] numbers=new int[]{3,2,5,6,3,6,10,20,1,25,30,50};
        Set<Integer> set1= new TreeSet<>();
        for(int i=0; i<numbers.length; i++){
            set1.add(numbers[i]);
        }
        System.out.println("Min number is: "+ Collections.min(set1));
        System.out.println("Max number is: "+Collections.max(set1));

        //Use Collections to sort string
        String[] students= new String[] {"Mike","Jason","Bob","Emily","Adam"};
        Set<String> set2= new TreeSet<>();
        Collections.addAll(set2, students);
        System.out.println("Min alphabet name is: "+Collections.min(set2,String.CASE_INSENSITIVE_ORDER));
        System.out.println("Max alphabet name is: "+Collections.max(set2,String.CASE_INSENSITIVE_ORDER));

    }
}
