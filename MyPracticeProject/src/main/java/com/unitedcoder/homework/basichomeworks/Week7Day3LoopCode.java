package com.unitedcoder.homework.basichomeworks;

public class Week7Day3LoopCode {
    public static void main(String[] args) {
        /*
Write a Java program that prints out how many numbers between 1 and 500 divisible by 3,or 5,
or 15 with zero remainder.  In addition,
1. You need to print all the numbers that can be divided by 3 on the console;
2. You need to print all the numbers that can be divided by 5 on the console.
3. You need to print all the numbers that can be divided by 15 on the console.
After finishing your code, package your project as a Jar file and execute your code in the OS command
 prompt or terminal.
         */
        System.out.println("Numbers Divided by 3: ");
        int count3=0;
        for (int i=1; i <=500; i++) {
            if (i % 3 == 0) {
                count3++;
                System.out.print(i + " ");
            }
        }
        System.out.println("\nNumbers Divided by 5: ");
        int count5=0;
        for (int i=1; i <=500; i++) {
            if (i % 5 == 0) {
                count5++;
                System.out.print(i + " ");
            }
        }
        System.out.println("\nNumbers Divided by 15: ");
        int count15=0;
        for (int i=1; i <=500; i++) {
            if (i % 15 == 0) {
                count15++;
                System.out.print(i + " ");
            }
        }
        System.out.println("\nTotal numbers of divisible by 3: "+count3);
        System.out.println("Total numbers of divisible by 5: "+count5);
        System.out.println("Total numbers of divisible by 15: "+count15);
    }

}
