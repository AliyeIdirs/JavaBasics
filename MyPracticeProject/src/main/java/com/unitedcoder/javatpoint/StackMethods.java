package com.unitedcoder.javatpoint;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class StackMethods {
    public static void main(String[] args) {

        //peek() method
        Stack<String> stk=new Stack<>();
        stk.push("Apple");
        stk.push("Grapes");
        stk.push("Mango");
        stk.push("Orange");
        System.out.println("stack: "+stk);
        //Access elements from the top of the stack (LIFO)
        String fruits=stk.peek();
        System.out.println("Element at top: "+fruits);

        //search() method
        Stack<String> stk2=new Stack<>();
        stk2.push("Mac Book");
        stk2.push("HP");
        stk2.push("DELL");
        stk2.push("Asus");
        System.out.println("stack: "+stk2);
        //search an element
        int location=stk2.search("HP");
        System.out.println("Location of HP:" +location);

        //size() method
        boolean rslt=stk2.empty();
        System.out.println("Is the stack empty? " +rslt);
        int x=stk2.size();
        System.out.println("The stack size is: "+x);

        //Iterate elements
        //Iterator method
        Iterator<String> iterator=stk2.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+", ");
        }
        System.out.println();

        //for-each loop
        for(String s:stk){
            System.out.print(s+", ");
        }
        System.out.println();

        //ListIteraor method
        ListIterator<String> itr2=stk.listIterator(stk.size());
        while(itr2.hasPrevious()){
            System.out.print(itr2.previous()+" ");
        }
        System.out.println();

        //forEach method
        stk2.forEach(n->
        {
            System.out.print(n+" ");
        });
        System.out.println();

        //for loop
        for(int i=0; i<stk.size();i++){
            System.out.print(stk.get(i)+" ");
        }

    }
}
