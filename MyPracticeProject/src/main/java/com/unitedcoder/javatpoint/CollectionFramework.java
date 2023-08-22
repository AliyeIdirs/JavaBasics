package com.unitedcoder.javatpoint;

import java.util.*;

public class CollectionFramework {
    public static void main(String[] args) {
        //ArrayList
        ArrayList<String> list=new ArrayList<String>(); //creating an arraylist
        list.add("Ravi"); //Adding object in arraylist
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");

        //Traversing List through Iterator
        Iterator itr=list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        //LinkedList
        LinkedList<String> al=new LinkedList<String>();
        al.add("Ravi");
        al.add("Vijay");
        al.add("Ravi");
        al.add("Ajay");
        Iterator<String> iterator=al.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //Vector
        Vector<String> v=new Vector<String>();
        v.add("Ayush");
        v.add("Amit");
        v.add("Ashish");
        v.add("Garima");
        Iterator<String> itr1=v.iterator();
        while(itr1.hasNext()){
            System.out.println(itr1.next());
        }

        //Stack --LIFO (Last In First Out)
        Stack<String> stack=new Stack<String>();
        stack.push("Ayush");
        stack.push("Garvit");
        stack.push("Amit");
        stack.push("Ashis");
        stack.push("Garima");
        stack.pop(); //remove the last element
        Iterator<String> itr2=stack.iterator();
        while(itr2.hasNext()){
            System.out.println(itr2.next());
        }
    }
}
