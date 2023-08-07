package com.unitedcoder.collectiondatastructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindDuplicateElement {
    public static void main(String[] args) {
        List<String> fruitList=new ArrayList<>();
        fruitList.add("Banana");
        fruitList.add("Apple");
        fruitList.add("Pear");
        fruitList.add("Strawberry");
        fruitList.add("Grape");
        fruitList.add("Apple");
        fruitList.add("Banana");
        fruitList.add("Orange");

        HashSet<String> set=new HashSet<>();
        for (int i=0; i<fruitList.size(); i++){
            String fruits=fruitList.get(i);
            if (!set.add(fruits)) {
                System.out.println(fruits+ " is duplicated");
            }
        }
    }
}
