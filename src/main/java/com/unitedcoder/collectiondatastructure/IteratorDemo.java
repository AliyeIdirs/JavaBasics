package com.unitedcoder.collectiondatastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(60); list1.add(80);
        list1.add(90); list1.add(100);

        //printing out each element of arraylist using Iterator Interface
        Iterator<Integer> iterator=list1.iterator(); //Iterator Interface
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" "); //60 80 90 100
        }
        System.out.println();

        ArrayList<Integer> list2=new ArrayList<>();
        list2.addAll(list1);

        //print out elements before third index
        ListIterator<Integer> it= list2.listIterator(3); //ListIterator Interface
        while(it.hasPrevious()){ //print from ending to beginning
            System.out.print(it.previous()+" "); //90 80 60
        }
    }
}
