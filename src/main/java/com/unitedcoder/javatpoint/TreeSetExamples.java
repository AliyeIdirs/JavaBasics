package com.unitedcoder.javatpoint;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExamples {
    public static void main(String[] args) {

        //Example 1
        TreeSet<String> al= new TreeSet<>();
        al.add("Ravi");
        al.add("Vijay");
        al.add("Ravi");
        al.add("Ajay");

        Iterator<String> iterator= al.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" "); //only contains unique value
        }
        System.out.println();

        //Traversing element through Iterator in descending order
        Iterator<String> itr=al.descendingIterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
        System.out.println();
        System.out.println("*******************************************************************");

        //Example 2
        //retrieve and remove the highest and lowest value
        TreeSet<Integer> set=new TreeSet<>();
        set.add(24);
        set.add(66);
        set.add(12);
        set.add(15);
        System.out.println("Lowest Value: " +set.pollFirst());
        System.out.println("Highest Value: "+set.pollLast());
        System.out.println("*******************************************************************");


        //Example 3
        //NavigableSet operation
        TreeSet<String> set1=new TreeSet<>();
        set1.add("A");
        set1.add("B");
        set1.add("C");
        set1.add("D");
        set1.add("E");
        System.out.println("Initial Set:" +set1);
        System.out.println("Reverse Set: "+set1.descendingSet());
        System.out.println("Head Set: "+ set1.headSet("C",true));
        System.out.println("SubSet: "+set1.subSet("A",false,"E",true));
        System.out.println("TailSet: "+set1.tailSet("C",false));
        System.out.println("*******************************************************************");

    }
}
