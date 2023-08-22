package com.unitedcoder.collectiondatastructure;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>(); //Queue interface can't be used directly
        queue.add(1);    queue.add(2);
        queue.add(3);    queue.add(4);
        System.out.println(queue);

        //FIFO-- First in first out in Queue
        queue.remove(); //remove the first element
        System.out.println(queue);

        queue.peek(); //check the element of the queue, if empty return null
        queue.poll(); //remove the head of the queue, if empty return null
        System.out.println(queue);
        queue.poll();
        queue.remove();// if empty gives error
        System.out.println(queue);

    }
}
