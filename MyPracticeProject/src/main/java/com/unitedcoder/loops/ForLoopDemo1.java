package com.unitedcoder.loops;

public class ForLoopDemo1 {
    public static void main(String[] args) {

        for(int i=0; i <100; i++){
            System.out.println(i);
        }
        for (int i=1; i<1000; i+=4){
            System.out.print(i+" ");
        }
        String s="Odd";
        for (int j=0; j<=s.length();j++){
            System.out.println(j);
        }
        for (int j=0; j<=100; j+=2){
            System.out.println(j);
        }
    }
}
