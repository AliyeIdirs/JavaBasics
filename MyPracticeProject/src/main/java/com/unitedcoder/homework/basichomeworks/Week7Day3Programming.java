package com.unitedcoder.homework.basichomeworks;

public class Week7Day3Programming {
    public static void main(String[] args) {
        /*
    Write a Java code for the Compound Interest problem below?
    You invested $1000 in a bank. The bank will return 5% interest every year. If you keep your money in a bank for
    five years, what is your final value of your investment?
    Note: use Math.pow function in java for the power calculation. P*Math.pow((1+r/n),n*t)
    Use the formula as a reference.
    A= P*(1 + r/n)^(n*t)
    P = principal amount (the initial amount you borrow or deposit)            (P=$1000)
    r  = annual rate of interest (as a decimal)                                (r=5%)
    t  = number of years the amount is deposited or borrowed for.              (t=5)
    A = amount of money accumulated after n years, including interest.         (You need to calculate A in your Java code)
    n  =  number of times the interest is compounded per year                  (n=1)
         */
        int P=1000;
        double r=0.05;
        int t=5;
        int n=1;
        double A=0;
        for (int i=0; i<=t; i++){
            A=P*Math.pow((1+r/n),n*t);
            System.out.printf("%d. time balance is %.2f%n",n,A);
            n++;
        }
        System.out.printf("Final Balance is: %.2f%n",A);
        System.out.printf("the interest is compounded %d times per year%n",n);

    }
}
