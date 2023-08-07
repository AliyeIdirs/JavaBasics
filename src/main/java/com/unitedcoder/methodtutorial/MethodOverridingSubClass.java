package com.unitedcoder.methodtutorial;

public class MethodOverridingSubClass extends MethodOverridingDemo{

    public void printTestInfo(){
        System.out.println("Test case Id = 1");
        System.out.println("Test case name = Login");
        System.out.println("Test case description: user login test");
    }

    //use subclass method
    public static void main(String[] args) {
        MethodOverridingDemo methodOverridingDemo= new MethodOverridingSubClass();
        methodOverridingDemo.printTestInfo();

        //use parent class method
        MethodOverridingDemo demo1=new MethodOverridingDemo();
        demo1.printTestInfo();
    }

}
