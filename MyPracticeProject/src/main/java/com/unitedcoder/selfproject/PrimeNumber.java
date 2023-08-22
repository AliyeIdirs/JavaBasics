package com.unitedcoder.selfproject;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

import static com.google.common.math.IntMath.isPrime;

public class PrimeNumber {
    public static void main(String[] args) {
        //Solution 1
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        for (int i = 2; i < num; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                System.out.print(i + " ");
        }
        System.out.println();


        //Solution 2
        for (int i = 1; i < num; i++) {
            int count = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0)
                    count++;
            }
            if (i != 1 && count == 0)
                System.out.print(i + " ");
        }
        System.out.println();


        //Solution 3 (ready method)
        for (int i = 1; i < num; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }


}
