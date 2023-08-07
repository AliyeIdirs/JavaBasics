package com.unitedcoder.datatypes;

public class StringDemo3 {
    public static void main(String[] args){
        String result= " All Test Passed ";
        System.out.println(result.length()); //17
        System.out.println((result.trim()).length()); //15
        result=result.replace(" ", "");
        System.out.println(result.length()); //13

        //String format
        String course="United Coder";
        String course1="Selenium Master";
        String course2="Java Selenium Course";
        System.out.printf("Welcome to %s%n",course1);

        int i1=100;
        int i2=200;
        System.out.println(i1+i2);
        System.out.printf("%d +%d = %d%n",i1,i2,i1+i2);
        System.out.printf("%d + %d = %d",i1,i2,i1+i2);

        boolean b1=true;
        boolean b2=false;
        System.out.printf("Login Test Passed %b%n",b1);
    }
}
