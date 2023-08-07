package com.unitedcoder.selfproject;

public class DiamondShape {
    public static void main(String[] args) {

        //Using for Loop
        String output1 = "Using for Loop:\n";
        System.out.println("Using for Loop:");
        int stairs = 6;
        int i;
        int j;
        for (i = 1; i <= stairs; i++) {
            for (j = 1; j <= stairs - i; j++) {
                System.out.print(" ");
            }
            for (j = 1; j <= i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (i = stairs - 1; i > 0; i--) {
            for (j = 1; j <= stairs - i; j++) {
                System.out.print(" ");
            }
            for (j = 1; j <= i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //Using While Loop
        String output2 = "Using While Loop:\n";
        System.out.println("Using While Loop:");
        int number = 6;
        int m = 1;
        int n;
        while (m <= number) {
            n = 1;
            while (n++ <= number - m) {
                System.out.print(" ");
            }
            n = 1;
            while (n++ <= m * 2 - 1) {
                System.out.print("*");
            }
            System.out.println();
            m++;
        }
        m = number - 1;
        while (m > 0) {
            n = 1;
            while (n++ <= number - m) {
                System.out.print(" ");
            }
            n = 1;
            while (n++ <= m * 2 - 1) {
                System.out.print("*");
            }
            System.out.println();
            m--;
        }

        //Using Do While Loop:
        String output3 = "Using Do While Loop:\n";
        System.out.println("Using Do While Loop:");
        int boundary = 6; int row = 1; int column;
        do {
            column = 1;
            do {
                System.out.print(" ");
            }
            while (++column <= boundary - row+1);
            column = 1;
            do {
                System.out.print("*");
            }
            while (++column <= row * 2 - 1);
            System.out.println();
        } while (++row <= boundary);
        row = boundary - 1;
        do {
            column = 1;
            do{
                System.out.print(" ");
            } while (++column <= boundary - row +1 );
            column = 1;
            do {
                System.out.print("*");
        } while (++column <= row * 2 - 1);
        System.out.println();
        }
        while(--row >0);
        // Concatenate the StringBuilder objects into a single string with tabs in between
        String output = output1 + "\t" + output2 + "\t" + output3;
        System.out.println(output);

    }
}
