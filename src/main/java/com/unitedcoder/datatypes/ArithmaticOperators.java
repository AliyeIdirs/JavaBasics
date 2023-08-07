package com.unitedcoder.datatypes;

public class ArithmaticOperators {
    public static void main(String[] args) {
        // + - * /
        //Premier of Rectangle (width + height) * 2
        int width=45; int height=25;
        int area=width*height;
        int premier=(width+height)*2;
        System.out.println("Area of rectangle is: " +area);
        System.out.println("Premier of rectangle is: " +premier);

        float division=(float)width/height;
        System.out.println(division);

        System.out.println(5%3);

        // Increment & Decrement
        int i=2;
        int j=1;
        i++;   //3
        j++;   //2
        System.out.println(i);
        System.out.println(j);
        i++;   //4
        j--;   //1
        j--;   //0
        ++i;   //5
        --j;   //-1 ;
        System.out.println(i); //5
        System.out.println(j); //-1

        i=i+2;
        j=j+2;
        System.out.println(i);     //7
        System.out.println(j);     //1

        System.out.println("************************************");

        int x= 10;
        int y= x++;
        int z= 20+(x++);
        int w= ++x;
        int f =100 -(++x);
        System.out.println(x); //14
        System.out.println(y); //10
        System.out.println(z); //31
        System.out.println(w);//13
        System.out.println(f);//86

        
    }
}
