package com.unitedcoder.datatypes;

public class DataTypeDemo1 {
    public static void main(String[] args){
        //byte data type
        byte b1=100;
        System.out.println(b1);
        b1=120;
        System.out.println("b1 Value After Change: "+b1);

        //short
        short s1=1000;
        System.out.println(s1);
        short s2=2000;
        System.out.println("Short Min Value" +Short.MIN_VALUE);
        System.out.println("Short Min Value" +Short.MAX_VALUE);
        int s3=s1+s2;
        System.out.println(s3);

        //int vs long
        int i1=2000;
        int i2=3000;
        long l1=200000000000L;

        //double vs float
        float f1=123.2794f;
        double d1=7865.34354324;
        System.out.println(f1);
        System.out.println(d1);

        //boolean
        boolean b2=true;
        boolean b3=false;
        System.out.println("10 is greater than 20 is: "+b3);
        System.out.println("Login Test Passed! "+b2);

        //char
        char c1='A';
        char c2='C';
        System.out.println(c1);
        System.out.println(c2);
            //ASCII code value
            int value1=c1;
            int value2=c2;
            char c3=66;
            System.out.println(value1);
            System.out.println(value2);
            System.out.println(c3);




    }
}
