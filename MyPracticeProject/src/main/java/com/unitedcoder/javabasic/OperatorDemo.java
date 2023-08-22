package com.unitedcoder.javabasic;

public class OperatorDemo {

    public static void main(String [] args){
        //Addition
        int x = 15; int y =5;
        int addResult=x+y;
        System.out.printf("%d + %d = %d%n",x,y,addResult);

        //Subtraction
        int subResult=100-25;
        System.out.println("100-25 = " +subResult);

        //Multiplication
        int recWidth =10; int recLength =20;
        int area= recWidth*recLength;
        System.out.printf("Area of a rectangle %d by %d is %d%n", recWidth, recLength,area);

        //Division
        float divResult=(float) 25/3;
        System.out.printf("%.2f%n",divResult);

        int d=2;
        if (d==0)
            System.out.println("a divisor cannot be zero");
        else {
            int anotherDiv=20 /d ;
            System.out.println(anotherDiv);
        }
        float divResult1=(float) 25/3 ;
        int remResult=25%3;
        System.out.println(divResult1);
        System.out.println(remResult);

        //Math library
        System.out.println("10 to the power of 2: " +Math.pow(10,2));
        System.out.println("Square root of 10: "+ Math.sqrt(10));
        System.out.println(Math.max(10,100));
        System.out.println(Math.min(10,100));
        System.out.println(Math.round(3.7));

        //Relational Operators
        int value1= 10; int value2= 9;
        System.out.println(value1 != value2);
        System.out.println("apple" == "apple");
        System.out.println(value1 >= value2);
        System.out.println(value1 < value2);


        //Increment/Decrement Operators
        int i1=1;
        int j1=1;
        i1 ++; j1 --;
        System.out.println("i1 = " +i1);
        System.out.println("j1 = " +j1);

        //Boolean (Conditional) Operators
        //&& -> AND operator --the result is ture when all conditions are true
        //|| -> OR operator -- the result is true only when at least oen condition is true
        int number1= 5; int number2= 10;
        boolean result=(number1==5) && (number2==9);
        System.out.println(result);
        System.out.println((number1==5)||(number2==9));

        //Bitwise Operators
        //Binary "Bitwise" Operators
        /*
        Some common bit operators
        ~ -the unary complement (tam tersini gösterir)
        & -Bitwise and
        ^ -Bitwise exclusive or
        | -Bitwise inclusive or
        Example:
        1010 & 0101 == 0000
        1100 & 0110 == 0100

        1010 | 0101 == 1111
        1100 | 0110 == 1110

        ~ 1111 == 0000
        ~ 0011 == 1100

        1010 ^ 0101 == 1111
        1100 ^ 0110 == 1010
         */

        byte a=100; byte b= 110;
        //boolean OR operation
        byte c=(byte) (a|b);
        System.out.println("Boolean OR Operation: " +c);
        //boolean AND operation
        byte f=(byte) (a&b);
        System.out.println("Boolean AND Operation: " +f);

        //type comparison operator: instanceof
        Number n=10.5;
        System.out.println(n instanceof Double);

        Object o="1";
        if (o instanceof String)
            System.out.println("Yes, it is String");
        else
        {
            System.out.println("No, it is not String");

        }
        System.out.println(o instanceof String?"Yes String": "not String");

    }

}
