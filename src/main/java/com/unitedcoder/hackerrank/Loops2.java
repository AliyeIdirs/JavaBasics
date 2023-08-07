package com.unitedcoder.hackerrank;

import java.util.Scanner;

public class Loops2 {
    public static void main(String[] args) {

        //https://www.hackerrank.com/challenges/java-loops/problem?isFullScreen=true

        Scanner scan= new Scanner(System.in);
        int t= scan.nextInt();
        for (int i=0; i<t; i++){
            int a= scan.nextInt();
            int b= scan.nextInt();
            int n= scan.nextInt();
            int calc=a;
            for(int j=0;j<n; j++){
                calc+=(Math.pow(2,j)*b);
                System.out.print(calc+" ");
            }
            System.out.println();
        }
        scan.close();
    }
}
