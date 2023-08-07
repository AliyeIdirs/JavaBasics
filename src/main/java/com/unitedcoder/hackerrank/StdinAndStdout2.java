package com.unitedcoder.hackerrank;

import java.util.Scanner;

public class StdinAndStdout2 {
    public static void main(String[] args) {

        //https://www.hackerrank.com/challenges/java-stdin-stdout/problem?isFullScreen=true

        Scanner input= new Scanner(System.in);
        int a= input.nextInt();
        double b= input.nextDouble();

        input.nextLine();
        String c= input.nextLine();

        System.out.println("String: "+c);
        System.out.println("Double: "+b);
        System.out.println("Int: "+a);

    }
}
