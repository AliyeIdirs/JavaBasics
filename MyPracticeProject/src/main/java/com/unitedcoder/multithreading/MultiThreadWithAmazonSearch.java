package com.unitedcoder.multithreading;

public class MultiThreadWithAmazonSearch {
    public static void main(String[] args) {
        AmazonSearch amazonSearch1= new AmazonSearch("Java Book");
        AmazonSearch amazonSearch2= new AmazonSearch("Iphone Case");
        AmazonSearch amazonSearch3= new AmazonSearch("Baby Stroller");
        AmazonSearch amazonSearch4= new AmazonSearch("air pods");
        AmazonSearch amazonSearch5= new AmazonSearch("table");

        Thread thread1= new Thread(amazonSearch1);
        Thread thread2= new Thread(amazonSearch2);
        Thread thread3= new Thread(amazonSearch3);
        Thread thread4= new Thread(amazonSearch4);
        Thread thread5= new Thread(amazonSearch5);


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();



    }
}
