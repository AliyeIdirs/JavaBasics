package com.unitedcoder.hackerrank;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class EndOfFile {
    public static void main(String[] args) {
        //https://www.hackerrank.com/challenges/java-end-of-file/problem?isFullScreen=true

        Scanner scan= new Scanner(System.in);
        int i=1;
        while(scan.hasNext()) {
            String s=scan.nextLine();
            System.out.println(i +" " +s);
            i++;
        }
    }
}
