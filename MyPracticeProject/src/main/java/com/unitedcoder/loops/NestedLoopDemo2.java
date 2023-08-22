package com.unitedcoder.loops;

public class NestedLoopDemo2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            int j = 1;
            while (j <= i) {
                j++;
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = 1; i <= 5; i++) {
            int j = 1;
            do {
                System.out.print("* ");
                j++;
            }
            while (j <= i);
            System.out.println();
        }

    }
}
