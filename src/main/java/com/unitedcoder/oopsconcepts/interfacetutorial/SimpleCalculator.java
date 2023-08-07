package com.unitedcoder.oopsconcepts.interfacetutorial;

public interface SimpleCalculator {

    String version="2.0"; //by default, a variable type in the interface is static final

    //only accept abstract method
    //the default and only access modifier of an interface method is "public abstract"
    //no need to write public abstract, because java automatically recognizes interface
    //abstract method can not have code body, only name
    double addTwoNumbers(int a, int b); //method name, return type, argument, but no implementation
    int addMultipleNumbers(int...numbers);
    double multiplyTwoNumber(double d1,double d2);
    float divideTwoNumbers(double x, double y);

    //we can create a private interface, but it should have code body
    private long subtractTwoNumbers(long l1, long l2){
        System.out.println(l1-l2);
        return(l1-l2);
    }
}
