package com.unitedcoder.multithreading;

import java.util.Date;

public class ThreadClass implements Runnable{
    private String message;

    public ThreadClass() {
    }

    public ThreadClass(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for(int i=0; i<=5; i++){
            Date now = new Date();
            System.out.println(now + " " + message);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
