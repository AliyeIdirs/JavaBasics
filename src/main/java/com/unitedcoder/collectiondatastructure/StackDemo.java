package com.unitedcoder.collectiondatastructure;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> s1=new Stack<>();
        s1.push("Book1"); //insert element
        s1.push("Book2");
        s1.push("Book3");
        s1.push("Book4");
        System.out.println(s1);
        //LIFO -- Last In First Out
        s1.pop(); //removes element
        System.out.println(s1);
        s1.peek(); //looks at the top element without removing it
        System.out.println(s1);
        System.out.println(s1.empty());
        System.out.println(s1.search("Book2")); //search the index of the element,it counts from the last to first

    }
}
