package com.unitedcoder.javatpoint;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {

        //Example 1
        LinkedHashSet<String> set= new LinkedHashSet<>();
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");
        set.add("Five");
        Iterator<String> iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();

        //Example 2
        //LinkedHashSet ignoring duplicate elements
        LinkedHashSet<String> set2=new LinkedHashSet<>();
        set2.add("Ravi");
        set2.add("Vijay");
        set2.add("Ravi");
        set2.add("Ajay");
        Iterator<String> itr=set2.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
        System.out.println();

        //Example 3
        //Methods
        LinkedHashSet<String> ihs= new LinkedHashSet<>();
        ihs.add("Java");
        ihs.add("T");
        ihs.add("Point");
        ihs.add("Good");
        ihs.add("Website");
        System.out.println("The hash set is: "+ihs);
        System.out.println(ihs.remove("Good")); //true
        System.out.println("After removing the element, the hash set is: " +ihs);

        System.out.println(ihs.remove("For")); //false, because For is not present


    }
}
