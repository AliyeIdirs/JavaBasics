package com.unitedcoder.homework.basichomeworks;

import java.util.Arrays;

public class Week8Day2ArrayCode {
    public static void main(String[] args) {

/*
        double[] values=new double[10];
        for(int i=1;i<=10;i++)
        values[i]=i*i;
        Explain the ways of fixing the error.
*/
        double[] values=new double[10];
        for(int i=1;i<10;i++) { //1 4 9 16 25 36 49 64 81 100
            values[i] = i * i;
        }
        System.out.println(Arrays.toString(values));
        System.out.println(values.length);
        //missing { after for
        //<= sign out of the bound which contains 11 elements.

    }
}
