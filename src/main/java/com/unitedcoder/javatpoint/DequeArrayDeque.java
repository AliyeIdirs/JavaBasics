package com.unitedcoder.javatpoint;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeArrayDeque {
    public static void main(String[] args) {

        //Example 1
        Deque<String> deque=new ArrayDeque<>();
        deque.add("Ravi");
        deque.add("Vijay");
        deque.add("Ajay");
        for(String str:deque){
            System.out.println(str);
        }


        //Example 2
        //offerFirst() and pollLast() methods
        Deque<String> deque1= new ArrayDeque<>();
        deque1.add("arvind");
        deque1.add("vimal");
        deque1.add("mukul");
        deque1.offerFirst("jai"); //add element to the first order
        System.out.println("After offerFirst Traversal...");
        for(String s:deque1){
            System.out.println(s);
        }

        //deque.poll() = deque.pollFirst()
        deque1.pollLast(); //remove last element
        System.out.println("After pollLast() Traversal...");
        for(String t:deque1){
            System.out.println(t);
        }
    }
}
