package com.unitedcoder.datatypes;

import java.util.Random;

public class MathOperators {
    public static void main(String[] args) {
        int i1=100;
        System.out.println(Math.max(100,150));
        System.out.println(Math.min(20,400));
        System.out.println(Math.abs(-90));
        System.out.println(Math.pow(3,4));

        //Random range 0.0 -0.9999999999999999
        System.out.println(Math.random());

        //0-10
        int randomNumbers=(int) (Math.random()*11);
        System.out.println(randomNumbers);
        //35-50
        int r1=(int) (Math.random()*(50-35)+1)+35;
        System.out.println(r1);

        //Random Class
        Random random = new Random();
        System.out.println(random.nextInt());



    }
}
