package com.unitedcoder.javabasic;

public class NumericDemo {
    public static void main(String[] args)
    {
        //byte data type
        byte a=100;
        byte b=110;
        byte c=(byte) (a&b);
        byte d=(byte) (a|b);
        System.out.println("********** Example for byte **********");
        System.out.println("Byte 100 AND byte 110 is " +c);
        System.out.println("Byte 100 OR byte 110 is " +d);

        //short data type
        short s1=3500;
        short s2=6000;
        short s3=(short) (s1+s2);
        System.out.println("\n********** Example for short **********");
        System.out.printf("%d + %d=%d%n",s1,s2,(short)(s1+s2));

        //int data type
        int i1=1000000;
        int i2=2000000;
        int i3=i1+i2;
        System.out.println("\n********** Example for int **********");
        System.out.printf("%d+%d=%d%n", i1,i2,i3);
        System.out.println(i1 + "+" +i2+ "="+i3);

        //long data type
        long l1=12345678908888L;
        long l2=9878958585757577L;
        long l3=l1*l2;
        System.out.println("\n********** Example for long **********");
        System.out.printf("%d*%d=%d%n",l1,l2,l3);

        //float data type
        float f1=12.5123f;
        float f2=1.5f;
        float f3=f1+f2;
        System.out.println("\n********** Example for float **********");
        System.out.printf("%.3f+%.3f=%.2f%n",f1,f2,f3);

        //double data type
        double d1=100000.09;
        double d2=10000090.0000056798;
        double d3=d1+d2;
        System.out.println("\n********** Example for double **********");
        System.out.printf("%.1f+%.1f=%.1f%n",d1,d2,d3);

    }
}
