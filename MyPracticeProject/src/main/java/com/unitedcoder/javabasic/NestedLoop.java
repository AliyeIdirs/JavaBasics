package com.unitedcoder.javabasic;

public class NestedLoop {
    public static void main(String[] args) {
        //nested for loop
        for(int i=1; i<=4; i++)
        {
            for(int j=1; j<=i; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
