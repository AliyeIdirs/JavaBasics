package com.unitedcoder.oopsconcepts.polymorphism;

public class AnimalApplication {
    public static void main(String[] args) {
        Animal animal= new Animal();
        animal.animalSound();
        animal.animalEat("foods");

        Cat cat= new Cat();
        cat.animalSound();
        cat.animalEat("fish");

        Dog dog= new Dog();
        dog.animalSound();
        dog.animalEat("bones");

        Animal c= new Cat(); //object c only can access methods in parent class
        System.out.println("Cat with Animal Object reference:");
        c.animalSound(); //in runtime java gives priority to child class method
        c.animalEat("mouse");
        c.animalSleep();

        Animal d= new Dog(); //object d only can access methods in parent class
        System.out.println("Dog with Animal Object reference:");
        d.animalSound(); //it print out Dog's property, not animal's
        d.animalEat("meat");
        d.animalSleep();
    }
}
