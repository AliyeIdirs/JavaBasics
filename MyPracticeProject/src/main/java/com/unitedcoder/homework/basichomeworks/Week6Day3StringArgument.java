package com.unitedcoder.homework.basichomeworks;

public class Week6Day3StringArgument {
    public static void main(String[] args) {
        int a=Integer.parseInt(args[0]);
        System.out.println(a);
        int b=Integer.parseInt(args[1]);
        System.out.println(b);

        System.out.printf("%d x %d = %d%n", a,b,a*b);

    }
}
