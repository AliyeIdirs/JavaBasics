package com.unitedcoder.oopsconcepts.abstracttutorial;

public abstract class Bank {
    //abstract class allows us to create any type of variable, not only static final
    int balance;
    final int amount=10000;
    static final int a= 1867;


    //abstract class allows us to create abstract and non-abstract methods together
    public abstract void loan();
    public void debt(){
        System.out.println("Bank Debt");
    }
    public void credit(){
        System.out.println("Bank Credit");
    }
}
