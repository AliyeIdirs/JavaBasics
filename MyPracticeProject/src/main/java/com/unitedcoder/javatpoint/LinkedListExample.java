package com.unitedcoder.javatpoint;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {

        //Example 1
        LinkedList<String> al=new LinkedList<>();
        al.add("Ravi");
        al.add("Vijay");
        al.add("Ravi");
        al.add("Ajay");

        Iterator<String> itr=al.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }

        //Example 2
        LinkedList<String> ll=new LinkedList<String>();
        ll.add("Ravi");
        ll.add("Vijay");
        ll.add("Ajay");
        ll.add("Anuj");
        ll.add("Gaurav");
        ll.add("Harsh");
        ll.add("Virat");
        ll.add("Gaurav");
        ll.add("Harsh");
        ll.add("Amit");
        System.out.println("Initial list of elements: "+ll);
        //removing specific element from linkedList
        ll.remove("Vijay");
        System.out.println("After invoking remove(Object) method:" +ll);
        //removing element on the basis of specific position
        ll.remove(0);
        System.out.println("After invoking remove(index) method: "+ll);

        LinkedList<String> ll2=new LinkedList<>();
        ll2.add("Ravi");
        ll2.add("Hanumat");
        System.out.println(ll2);
        ll.addAll(ll2);
        System.out.println("Updated List: "+ll);

        ll.removeAll(ll2);
        System.out.println("After invoking removeAll() method: "+ll);

        ll.removeFirst();
        System.out.println("After invoking removeFirst() method: "+ll);

        ll.removeLast();
        System.out.println("After invoking removeLast() method: "+ ll);

        ll.removeFirstOccurrence("Gaurav");
        System.out.println("After invoking removeFirstOccurrence() method: "+ll);

        ll.removeLastOccurrence("Harsh");
        System.out.println("After invoking removeLastOccurrence() method:" +ll);

        ll.clear();
        System.out.println("After invoking clear() method:" +ll);

        //Example 3: reverse a list of elements
        LinkedList<String> list=new LinkedList<>();
        list.add("Ravi");
        list.add("Vijay");
        list.add("Ajay");
        //Traversing the list of elements in reverse order
        Iterator i=list.descendingIterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}
