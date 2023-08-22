package com.unitedcoder.exceptionhandling;

public class Demo3 {
    public static void main(String[] args) {
        try {
            System.out.println(1 / 0);
        }catch(ArithmeticException a){
            a.printStackTrace();
        }


    }
}
