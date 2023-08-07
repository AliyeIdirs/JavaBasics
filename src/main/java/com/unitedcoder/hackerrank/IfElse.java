package com.unitedcoder.hackerrank;

import java.io.*;
public class IfElse {
    public static void main(String[] args) throws IOException {

        //https://www.hackerrank.com/challenges/java-if-else/problem?isFullScreen=true

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        if(N%2!=0){
            System.out.println("Weird");
        }else if (N%2==0){
            if (N<=5 && N>=2){
                System.out.println("Not Weird");
            }else if (N<=20 && N>=6){
                System.out.println("Weird");
            }else{
                System.out.println("Not Weird");
            }
        }
        bufferedReader.close();
    }
}
