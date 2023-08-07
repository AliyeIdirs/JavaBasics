package com.unitedcoder.javatpoint;

import java.util.Iterator;
import java.util.PriorityQueue;

public class QueueAndPriorityQueue {
    public static void main(String[] args) {

        //PriorityQueue Example 1
        PriorityQueue<String> queue= new PriorityQueue<>();
        queue.add("Amit");
        queue.add("Vijay");
        queue.add("Karan");
        queue.add("Jai");
        queue.add("Rahul");
        System.out.println("head:"+queue.element()); //gives head element
        System.out.println("head:" +queue.peek());
        System.out.println("iterating the queue elements:");
        Iterator<String> itr=queue.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
        System.out.println();
        queue.remove(); //FIFO remove first element
        System.out.println(queue);
        queue.poll();  //remove second element
        System.out.println("after removing two elements:");
        Iterator<String> itr2=queue.iterator();
        while(itr2.hasNext()){
            System.out.println(itr2.next());
        }
    }
}
