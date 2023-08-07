package com.unitedcoder.javabasic;

import org.apache.commons.lang3.StringUtils;

public class TypeConversionDemo {
    public static void main(String[] args){
/*
        //Widening casting (implicit) byte->short->int->long->float->double
        //the target type is larger than the source type
        int x1=100;
        long l1=x1;   //no explicit type casting is required
        float f1=l1;  //no explicit type casting is required
        System.out.println("Int value " + x1);
        System.out.println("Long value " + l1);
        System.out.println("Float value " + f1);


        //Narrowing casting (explicitly done) double->float->long->int->short->byte
        //when you are assigning a larger type value to a variable of smaller type
        //Explicit type casting
        double d1= 13.56;
        long l=(long) d1;
        System.out.println("Double value "+ d1);
        //fractional part lost
        System.out.println("Long value " +l);
        System.out.println("Integer value " +(int) d1);

        //convert to float
        int i1=15;
        int i2=8;
        double i3= i1 /i2;
        float i4= (float) i1/i2;
        System.out.println(String.format("%d divided by %d equals %f",i1, i2, i3));
        System.out.println(String.format("%d divided by %d equals %f", i1, i2, i4));

        //convert numerical string to integer
        String s1= "1234";
        int i= 1234;
        System.out.println(s1+i); //s1 and i get combined to form a single one
        System.out.println(Integer.parseInt(s1) +i); //s1 and i will be added
*/
        //convert numerical string to double
        String s2= "123456.98";
        System.out.println("Double value of " + s2 +"is "+ Double.valueOf(s2));
        double d= Double.parseDouble(s2);
        System.out.println(d);
        System.out.printf("Double value of %s is %f%n",s2,Double.valueOf(s2));
        System.out.printf("Double value of %s is %f%n",s2,Double.parseDouble(s2));
        //convert numerical string to long
        System.out.println("Long value of " + s2 + "is " + Long.valueOf((long) Double.parseDouble(s2)));






    }
}
