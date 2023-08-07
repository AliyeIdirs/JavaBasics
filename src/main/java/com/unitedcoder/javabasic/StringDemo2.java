package com.unitedcoder.javabasic;

public class StringDemo2 {
    public static void main(String[] args)
    {
        String address="Main Street";
        String city="Columbia";
        String state="MD";
        int zipCode=20146;
        String fullAddress=String.format("My full address is: %s %s, %s, %d",address, city, state, zipCode);
        System.out.println(fullAddress);
    }
}
