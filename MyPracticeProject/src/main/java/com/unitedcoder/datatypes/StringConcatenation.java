package com.unitedcoder.datatypes;

public class StringConcatenation {

    public static void main(String[] args){

        //Numeric & Non Numeric
        String s1="Java";
        String s2="Test";
        String s3="100";
        String s4="200Plus";
        String s5="500";
        int i1=200;
        int i2=300;

        System.out.println(s1+s2);
        System.out.println(s1.concat(s2).concat(s3));

        System.out.println(s3+s5);//100500
        System.out.println(i1+i2);//500
        System.out.println(i1+s3);//200100
        System.out.println(s1+i1*i2);//Java60000
        System.out.println(i1+i2+s5+s1+s2);//500500JavaTest
        System.out.println(s2+s4);//Test200Plus
        System.out.println(s3+s4);//100200Plus
        System.out.println(s1+(i1+i2));//Java500


        //Contains
        String message="Customer added successfully";
        System.out.println(message.contains("successfully"));
        System.out.println(message.contains("Successfully"));
        System.out.println(message.toUpperCase().contains("Successfully"));



    }
}
