package com.unitedcoder.oopsconcepts.polymorphism;

public class Dog extends Animal{

    public void animalSound(){
        System.out.println("The dog says: hao hao");
    }

    public void animalEat(String foodName){
        System.out.println("The dog eats "+foodName);
    }

    public void dogRun(){
        System.out.println("The dog is running");
    }
}
