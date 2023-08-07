package com.unitedcoder.javatpoint;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExamples {
    public static void main(String[] args) {

        //Example 1
        ArrayList<String> list=new ArrayList<String>(); //Creating arraylist
        list.add("Mango");
        list.add("Apple");
        list.add("Banana");
        list.add("Grapes");
        //printing the arraylist object
        System.out.println(list);

        //Example 2
        ArrayList<String> list1=new ArrayList<String>(); //Creating arraylist
        list1.add("Pear");
        list1.add("Watermelon");
        list1.add("Strawberry");
        list1.add("Blueberry");
        //Traversing list through Iterator
        Iterator<String> itr1=list1.iterator();
        while(itr1.hasNext()){
            System.out.print(itr1.next()+" ");
        }
        System.out.println();

        //Example 3
        ArrayList<String> list2=new ArrayList<>();
        list2.add("Onion");
        list2.add("Carrot");
        list2.add("Potato");
        list2.add("Tomato");
        //Traversing list through for-each loop
        for(String s:list2){
            System.out.print(s+" ");
        }
        System.out.println();

        //Example 4
        //get() method returns the element at the specified index
        //set() method changes the element
        ArrayList<String> list3=new ArrayList<>();
        list3.add("Pepper");
        list3.add("Mushroom");
        list3.add("Cucumber");
        list3.add("Garlic");
        //Accessing the element
        System.out.println("Returning Element:"+ list3.get(1)); //it will return the 2nd element
        //changing the element
        list3.set(1,"Dates");
        for(String vegetable:list3) {
            System.out.print(vegetable+" ");
        }
    }
}
