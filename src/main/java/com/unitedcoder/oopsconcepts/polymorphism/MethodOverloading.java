package com.unitedcoder.oopsconcepts.polymorphism;

public class MethodOverloading {

    public void sum(int a, int b){
        System.out.println(a+b);

    }

    public void sum(float a, int b){
        System.out.println(a+b);

    }

    public void sum(double a, long b){
        System.out.println(a+b);

    }
}
