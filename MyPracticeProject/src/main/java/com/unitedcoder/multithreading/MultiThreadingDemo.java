package com.unitedcoder.multithreading;

import com.unitedcoder.methodtutorial.Calculator;

public class MultiThreadingDemo implements Runnable{

    @Override
    public void run() {
        System.out.println("This is multithreading example");
        System.out.println("This is another example");
        Calculator calculator=new Calculator();
        System.out.println(calculator.addTwoNumbers("10","40"));
    }

    public static void main(String[] args) {
        MultiThreadingDemo multiThreadingDemo=new MultiThreadingDemo();

        Thread t1=new Thread(multiThreadingDemo,"Print Thread1");
        Thread t2=new Thread(multiThreadingDemo,"Print Thread2");

        System.out.println("Thread 1 name: "+t1.getName());
        System.out.println("Thread 1 Id: "+t1.getId());

        Thread t3=new Thread(multiThreadingDemo);
        System.out.println("Thread 3 name: "+t3.getName());
        System.out.println("Thread 3 Id: "+t3.getId());

        System.out.println("Thread 2 name: "+t2.getName());
        System.out.println("Thread 2 Id: "+t2.getId());

        t1.start();
        t2.start();
        t3.start();
    }
}
