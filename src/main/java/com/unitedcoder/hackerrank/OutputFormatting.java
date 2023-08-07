package com.unitedcoder.hackerrank;

import java.util.Scanner;

public class OutputFormatting {
    public static void main(String[] args) {

        //https://www.hackerrank.com/challenges/java-output-formatting/problem?isFullScreen=true

        Scanner input= new Scanner(System.in);
        System.out.println("================================");
        for (int i=0; i<3; i++){
            String s= input.next();
            int a =input.nextInt();
            System.out.printf("%-14s %03d %n",s,a);
        }
        System.out.println("================================");
    }
}
