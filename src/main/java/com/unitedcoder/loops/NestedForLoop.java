package com.unitedcoder.loops;

public class NestedForLoop {
    public static void main(String[] args) {
        for (int i=1; i<=9; i++){
            for (int j=1; j<=9; j++){
                int multiply= i*j;
                System.out.printf("%d * %d = %d\t",i,j,multiply);
            }
            System.out.println();
        }
        System.out.println("*****************************************************************************************");
        for (int i=1; i<=9; i++) {
            for (int j = 1; j <= i; j++) {
                int multiply = i * j;
                System.out.printf("%d * %d = %d\t", i, j, multiply);
            }
            System.out.println();
        }
    }
}
