package com.unitedcoder.hackerrank;

import java.util.Scanner;

public class StaticInitializer {
    public static void main(String[] args) {

        //https://www.hackerrank.com/challenges/java-static-initializer-block/problem?isFullScreen=true

        Scanner scan=new Scanner(System.in);
        int breadth=scan.nextInt();
        int height=scan.nextInt();
        if(breadth>0 && height >0){
            System.out.println(((breadth+breadth)*height)/2);
        }else{
            System.out.println("java.lang.Exception: Breadth and height must be positive") ;
        }
    }
}
