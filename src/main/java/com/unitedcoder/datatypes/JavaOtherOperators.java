package com.unitedcoder.datatypes;

public class JavaOtherOperators {
    public static void main(String [] args){
        //Assignment operators: =; +=; -=; *=; /=;
        int x1=100; //Assignment
        x1++;
        x1 +=5; //x1=x1+5;
        System.out.println("*****************************");
        System.out.println(x1); //106

        x1 -=20; //x1= x1-20; // 86
        System.out.println(x1);
        x1 *=2; // x1=x1*2; // 172
        System.out.println(x1);
        x1 /=2;
        System.out.println(x1);

        x1 %= 3;
        System.out.println(x1);

        //comparison operators
        int i1= 200;
        int i2 = 300;
        int i3= 200;
        System.out.println(i1==i2);
        System.out.println(i1==i3);
        System.out.println(i1>i2);
        System.out.println(i2<i3);
        System.out.println(i1>=i3);
        System.out.println(i2>=i3);
        System.out.println(i1!=i2);
        System.out.println(i1<=i2);

        //Logical operators
        boolean b1=true;
        boolean b2=false;
        boolean b3=true;
        System.out.println("*****************************");
        System.out.println(b1&&b2); //false
        System.out.println(b1||b2); //true
        System.out.println(b1&&b3); //true
        System.out.println(b2||b3); //true
        System.out.println(!(b1&&b2)); //true

        int i4 =30;
        System.out.println(i4 <100 && i4 >80); // false
        System.out.println(i4<20 || i4>10); // true
        System.out.println(!(i4>50)); //true

        //Bitwise operators
        byte d1=001;
        byte d2= 110;
        System.out.println(d1&d2); //000
        System.out.println(d1|d2); //111
    }
}
