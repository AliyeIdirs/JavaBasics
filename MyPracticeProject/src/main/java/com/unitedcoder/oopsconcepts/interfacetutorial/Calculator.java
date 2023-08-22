package com.unitedcoder.oopsconcepts.interfacetutorial;

public class Calculator implements SimpleCalculator,IScientificCalculator{
    @Override
    public double addTwoNumbers(int a, int b) {
        return a+b;
    }

    @Override
    public int addMultipleNumbers(int... numbers) {
        int sum=0;
        for(int n:numbers){
            sum+=n;
        }
        return sum;
    }

    @Override
    public double multiplyTwoNumber(double d1, double d2) {
        return d1*d2;
    }

    @Override
    public float divideTwoNumbers(double x, double y) {
        if(y==0){
            System.out.println("The denominator can not be zero!");
            return 0;
        } else{
            float division= (float)(x/y);
            return division;
        }

    }

    @Override
    public double calculatePower(int base, int power) {
        double pow=Math.pow(base,power);
        return pow;
    }

    @Override
    public double calculateSquareRoot(long l) {
        double sqr=Math.sqrt(l);
        return sqr;
    }

    @Override
    public double calculateAbsoluteValue(int x) {
        double absValue=Math.abs(x);
        return absValue;
    }

    @Override
    public int minValue(int m, int n) {
        return Math.min(m,n);
    }
}
