package com.unitedcoder.oopsconcepts;

public class InnerClassDemo {

    private final String variable1= "Test Automation";

    //inner class can be abstract, final, public, protected, private and static

    //define a default innerclass A
   class InnerClassA{
       public void method1(){
           System.out.println("This is method of Inner Class A");
       }
   }
   public void innerInstance(){
       InnerClassA innerClassA= new InnerClassA();
       innerClassA.method1();
   }

   //define a static innerclass B
    static class InnerClassB{
       public static void method3(){
           System.out.println("This is method of static inner class B");
       }
   }
    public static void main(String[] args) {
       InnerClassDemo innerClassDemo= new InnerClassDemo();
        System.out.println(innerClassDemo.variable1);
        innerClassDemo.innerInstance();

        // a static nested class can be instantiated like this
        InnerClassDemo.InnerClassB classB=new InnerClassDemo.InnerClassB();
        InnerClassB.method3();

        InnerClassB.method3(); //because method3 is static, therefore no need to create new ıinstance

    }

}


