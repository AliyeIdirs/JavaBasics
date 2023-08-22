package com.unitedcoder.javatpoint;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetExamples {
    public static void main(String[] args) {

        //Example 1
        HashSet<String> set=new HashSet<>();
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");
        set.add("Five");
        Iterator<String> itr=set.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" "); //doesn't maintain insertion order
        }
        System.out.println();
        System.out.println("***************************************************************");


        //Example 2
        HashSet<String> set2=new HashSet<>();
        set2.add("Ravi");
        set2.add("Vijay");
        set2.add("Ravi");
        set2.add("Ajay");
        Iterator<String> itr2=set2.iterator();
        while(itr2.hasNext()){
            System.out.print(itr2.next()+" "); //doesn't allow duplicate value
        }
        System.out.println();
        System.out.println("********************************************************************");

        //Example 3
        //removing elements
        set2.remove("Ajay");
        set2.add("Arun");
        set2.add("Sumit");
        System.out.println("An initial list of elements:" +set2);
        set2.remove("Ravi");
        System.out.println("After invoking remove(object) method:" +set2);

        HashSet<String> set3=new HashSet<>();
        set3.add("Ajay");
        set3.add("Gaurav");
        set2.addAll(set3);
        System.out.println("Updated list: "+set2);

        //removing all new elements from HashSet
        set2.removeAll(set3);
        System.out.println("After invoking removeAll() method: "+set2);

        //removing elements on the basis of specified condition
        set2.removeIf(str->str.contains("Vijay"));
        System.out.println("After invoking removeIf() method: " +set2);

        //removing all available elements from the set
        set2.clear();
        System.out.println(set2);
        System.out.println("*********************************************************************");


        //Example 4
        //HashSet from another collection
        ArrayList<String> list=new ArrayList<>();
        list.add("Ravi");
        list.add("Vijay");
        list.add("Ajay");

        HashSet<String> hashSet=new HashSet<>(list);
        hashSet.add("Gaurav");
        Iterator<String> iterator= hashSet.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }
}
