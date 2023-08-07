package com.unitedcoder.methodtutorial;

import org.apache.commons.lang3.StringUtils;

public class Calculator {

    //method for print calculator information
    public void calculatorInfo(){
        System.out.println("Sony Simple Calculator");
        System.out.println("Hope you enjoy to use!!!");
    }

    //method for adding two numbers
    public int sum(int i1, int i2){
        System.out.println(i1+i2);
        return i1+i2;
    }

    public long addTwoNumbers(String s1, String s2) {
        if (StringUtils.isNumeric(s1) && StringUtils.isNumeric(s2)) {
            long sum = Long.parseLong(s1) + Long.parseLong(s2);
            System.out.println(sum);
            return sum;
        } else {
            System.out.println("Please provide numeric string!");
            return 0;
        }
    }

        //add multiple numbers
        public long addMultipleNumbers(long...numbers){
            long sum=0;
            for (long eachNumber:numbers){
                sum+=eachNumber;
            }
            System.out.println("Sum is :"+sum);
            return sum;
        }

    public static void main(String[] args) {
        Calculator calculator= new Calculator();
        calculator.calculatorInfo();
        calculator.sum(2,5);
        calculator.addTwoNumbers("54","ref43");
        calculator.addMultipleNumbers(23,6546,767,5435,33,4,45,65,76);

        FindMaxValueMethod method= new FindMaxValueMethod();
        System.out.println(method.findMaxValue(new int[]{30,10,70, 90, 105,45,23}));

        //use static method and variables
        StaticMethodAndVariable.setAccountBalance(1000);
        StaticMethodAndVariable.setAccountName("Aliye");
        StaticMethodAndVariable.setAccountNumber(123);
        System.out.println("Account Balance is: "+StaticMethodAndVariable.getAccountBalance());
        System.out.println("Account Name is: " +StaticMethodAndVariable.getAccountName());
        System.out.println("Account Number is: "+StaticMethodAndVariable.getAccountNumber());

        //use static and non-static variable
        StaticMethodAndVariable.money=200; //money is a static variable

        StaticMethodAndVariable staticMethod= new StaticMethodAndVariable();
        staticMethod.deposit=9000; //deposit is a non-static variable, it can be used only with object
    }
}
