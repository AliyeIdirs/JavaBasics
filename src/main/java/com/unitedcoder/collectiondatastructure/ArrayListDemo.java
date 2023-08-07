package com.unitedcoder.collectiondatastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        //Create a new arraylist
        ArrayList<String> names= new ArrayList<>();

        //Add items
        names.add("Bob");
        names.add("Smith");
        names.add("Mike");
        names.add("Jordan");
        //Set 2nd item
        names.set(1,"Emily");
        System.out.println("Total items: "+ names.size());

        for (String name:names){
            System.out.print(name+",");
        }
        System.out.println();
        //remove first item and print
        System.out.println("------removed first element");
        names.remove(0);
        for(String name:names){
            System.out.print(name+",");
        }
        System.out.println();
        //get specific element
        System.out.println("The second person is: "+names.get(1));

        //Convert array to arraylist
        System.out.println("----print number----");
        Integer[] evenNumbers=new Integer[]{2,4,6,8,10};
        Integer[] numberArrayList= evenNumbers;
        for(int number:numberArrayList){
            System.out.print(number +",");
        }



    }
}
