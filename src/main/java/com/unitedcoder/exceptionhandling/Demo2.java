package com.unitedcoder.exceptionhandling;

public class Demo2 {
    public static void sleep(int second) throws InterruptedException {
        Thread.sleep(second* 1000L);
        wait(3);
    }

    public static void wait(int sec){
        try {
            Thread.sleep(sec* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
