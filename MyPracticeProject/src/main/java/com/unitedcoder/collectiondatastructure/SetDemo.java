package com.unitedcoder.collectiondatastructure;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> states= new HashSet<>();
        states.add("Maryland");
        states.add("Virgina");
        states.add("Washington");
        states.add("Ohio");
        states.add("New York");
        states.add("New York");  //Set cannot contain duplicate elements
        states.add("Maryland");
        System.out.println("Set size is: "+states.size()); //5

        //iterate set
        Iterator<String> iterator=states.iterator();
        while(iterator.hasNext()){
            String state= iterator.next();
            System.out.println(state);
        }

        //use for loop to print
        System.out.println("---use for loop to print states----");
        for(String s:states){
            System.out.println(s);
        }
    }
}
