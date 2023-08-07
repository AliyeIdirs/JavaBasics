package com.unitedcoder.javatpoint;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackExamples {
    public static void main(String[] args) {

        //Example 1
        System.out.println("Example 1:");
        Stack<Integer> stk = new Stack<>();
        boolean result = stk.empty();
        System.out.println("Is the stack empty? " + result);
        stk.push(78);
        stk.push(113);
        stk.push(90);
        stk.push(120);
        System.out.println("Elements in stack: " + stk);
        result = stk.empty();
        System.out.println("Is the stack empty? " + result);
        System.out.println("***************************************************************************");


        //Example 2
        System.out.println("Example 2:");
        Stack<Integer> stack = new Stack<>();
        System.out.println("stack: " + stack);
        //pushing elements into the stack
        pushelmnt(stack, 20);
        pushelmnt(stack, 13);
        pushelmnt(stack, 89);
        pushelmnt(stack, 90);
        pushelmnt(stack, 11);
        pushelmnt(stack, 45);
        pushelmnt(stack, 18);
        //popping elements from the stack
        popelmnt(stack);
        popelmnt(stack);
        //throws exception if the stack is empty
        try {
            popelmnt(stack);
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
        System.out.println("***************************************************************************");

    }
    //performing push operation
    private static void pushelmnt(Stack<Integer> stack, int i) {
        //invoking push() method
        stack.push(Integer.valueOf(i));
        System.out.println("push->" +i);
        //prints modified stack
        System.out.println("stack:" +stack);
    }
    //performing pop operation
    private static void popelmnt(Stack<Integer> stack) {
        System.out.print("pop ->");
        //invoking pop() method
        Integer x = stack.pop();
        System.out.println(x);
        //prints modified stack
        System.out.println("stack: "+stack);
    }



}
