package com.unitedcoder.exceptionhandling;

public class ThrowKeyword {
    public static void main(String[] args) {
        try {
            System.out.println(1 / 4);
            throw new NullPointerException("Driver should be instantiated");
        }catch( Exception e){
            e.printStackTrace();
            System.out.println("Exception occurred");
        }
    }
}
