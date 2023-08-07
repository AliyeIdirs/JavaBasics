package com.unitedcoder.datatypes;

import org.apache.commons.lang3.StringUtils;

public class DataTypeConversion2 {
    public static void main(String[] args) {
        //Convert String to Primitive Data type
        String s1="25";//numeric string
        String price1="100$"; //non-numeric string
        String price2="110$";
        String price3="140$";
        int expectedTotalPrice=350;

        System.out.println(s1+price1);
        int i1=Integer.parseInt(s1);
        System.out.printf("Value after conversion is %d%n",i1);

        //convert non-numeric string to numeric string
        price1=price1.replace("$","");
        price2=price2.replace("$","");
        price3=price3.replace("$","");

        int p1=Integer.parseInt(price1);
        int p2=Integer.parseInt(price2);
        int p3=Integer.parseInt(price3);
        int totalSum=p1+p2+p3;

        System.out.printf("Total Sum is %d%n", totalSum);
        System.out.println(expectedTotalPrice==totalSum);

        String s2="true";
        boolean b1=Boolean.parseBoolean(s2);
        System.out.println(b1);

        //Convert primitive data type to String
        int i2=10000;
        int i3=9000;

        System.out.println(i2+i3);
        String s4=String.valueOf(i2);
        System.out.println(s4);
        String s5=Integer.toString(i3);
        System.out.println(s5);
        System.out.println(s4+s5);

        float f=3.14f;
        String t=Float.toString(f);
        System.out.println(StringUtils.isNumeric(t));

        int x=23;
        System.out.println(Integer.parseInt(""+x));
        System.out.println(StringUtils.isNumeric(""+x));


    }
}
