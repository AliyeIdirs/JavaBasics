package com.unitedcoder.exceptionhandling;

public class Demo5 {
    public static void main(String[] args) {
        int a= 10;
        int b=0;
        try{
            float c= a/b;
            System.out.println("Division value is "+ c);
        }catch(ArithmeticException e){
            e.printStackTrace();
        }
        finally{
            System.out.println("You can not divide any number by 0");
            System.out.println("Continue");
        }

    }
}
