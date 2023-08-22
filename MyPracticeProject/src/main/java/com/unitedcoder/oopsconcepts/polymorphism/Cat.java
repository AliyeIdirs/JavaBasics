package com.unitedcoder.oopsconcepts.polymorphism;

public class Cat extends Animal{

    public void animalSound(){
        System.out.println("The cat says: miao");
    }

    public void animalEat(String foodName){
        System.out.println("The cat eats "+foodName);
    }

    public void catRun(){
        System.out.println("The cat is running");
    }
}
