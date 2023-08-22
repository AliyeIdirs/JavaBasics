package com.unitedcoder.collectiondatastructure;

import java.util.*;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList=new LinkedList<>(); //here parent is LikenList
        List<Integer> list=new LinkedList<>();             //here parent is List
        Queue<Integer> list2= new LinkedList<>();          //here parent is Queue

        linkedList.add(60); linkedList.add(80);
        linkedList.add(90); linkedList.add(100);

        linkedList.addFirst(200); //only LinkedList have this method.
        linkedList.addLast(400);
        System.out.println(linkedList); //[200, 60, 80, 90, 100, 400]

        list.add(55);
        System.out.println(list); //[55]

        Iterator<Integer> it=linkedList.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }

        System.out.println();
        LinkedList<String> employees=new LinkedList<>();
        employees.addFirst("Mike");
        employees.addFirst("Sam");
        employees.addLast("James");
        System.out.println("Number of nodes: "+employees.size());
        for(String employee:employees) {
            System.out.print(employee + " ");
        }

            System.out.println("\n---Use Iterator for linked list----");
            //use iterator to remove an item and print
            ListIterator<String> iterator=employees.listIterator();
            if(iterator.next().equals("Sam")){
                iterator.remove();
            }
            iterator.add("Selenium");
            iterator.add("Master");
            iterator=employees.listIterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
    }
}
