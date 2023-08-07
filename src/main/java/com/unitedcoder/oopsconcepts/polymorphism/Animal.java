package com.unitedcoder.oopsconcepts.polymorphism;

public class Animal {

    public void animalSound(){
        System.out.println("The animal makes a sound");
    }

    public void animalEat(String foodName){
        System.out.println("The animal eats food "+foodName);
    }

    public void animalSleep(){
        System.out.println("Animal is sleeping");
    }
}
