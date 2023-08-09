package com.unitedcoder.homework.week11day2;

import java.util.Date;

public class MultiThreadingProject implements Runnable{
    private final String greeting;

    public MultiThreadingProject(String greeting) {
        this.greeting = greeting;
    }
    public void run() {
        try {
            for(int i=1; i<=5; i++) {
                Date now = new Date();
                System.out.println(now + " "+greeting);
                Thread.sleep(1000);
            }
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MultiThreadingProject greetingPrinting1=new MultiThreadingProject("Hello Selenium Master");
        MultiThreadingProject greetingPrinting2= new MultiThreadingProject("Java Multi Threading is fun");
        Thread r1=new Thread(greetingPrinting1);
        Thread r2= new Thread(greetingPrinting2);
        r1.start();
        r2.start();
    }

}
