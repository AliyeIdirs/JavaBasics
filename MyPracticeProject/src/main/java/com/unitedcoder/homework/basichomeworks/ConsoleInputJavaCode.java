package com.unitedcoder.homework.basichomeworks;

public class ConsoleInputJavaCode {
    public static void main (String[] args){
        int x= 34;
        int y= 87;

        System.out.printf("x = %d\ny= %d%n",x,y);

        //The sum of the two numbers;
        int sum= x+y;
        System.out.printf("%d + %d = %d%n",x,y,sum);

        //The difference between the two numbers;
        int diff= x-y;
        System.out.printf("Difference: %d - %d = %d%n", x, y,diff);

        //The product (multiplication) of the two numbers;
        int multip= x*y;
        System.out.printf("%d * %d = %d%n", x,y,multip);

        //The average of the two numbers;
        float average = (x + y)/2f;
        System.out.printf("Average = (%d + %d )/ 2 =%.2f%n", x,y,average);

        //The absolute values of the two number differences;
        System.out.printf("⎢%d-%d⎥ = %d%n",x,y,Math.abs(x-y));

        //The maximum of the two numbers;
        System.out.printf("Maximum is = %d%n",Math.max(x,y));

        //The minimum of the two numbers;
        System.out.printf("Minimum is= %d%n",Math.min(x,y));

        //The comparison of the two numbers
        int comp= Integer.compare(x,y);
        if (comp >0) {
            System.out.println("x > y");
        } else if (comp <0) {
            System.out.println("x < y");
        } else {
            System.out.println(" x = y");
        }

    }
}
