package com.unitedcoder.methodtutorial;

public class StaticMethodAndVariable {

    //static variables
    private static double accountBalance;
    private static String accountName;
    private static int accountNumber;
    public int deposit;
    public static int money;

    public StaticMethodAndVariable() {
    }

    //constructor
    public static double getAccountBalance() {
        return accountBalance;
    }


    //getter and setter
    //static method only accepts static variable
    public static void setAccountBalance(double accountBalance) {
        StaticMethodAndVariable.accountBalance = accountBalance;
    }

    public static String getAccountName() {
        return accountName;
    }

    public static void setAccountName(String accountName) {
        StaticMethodAndVariable.accountName = accountName;
    }

    public static int getAccountNumber() {
        return accountNumber;
    }

    public static void setAccountNumber(int accountNumber) {
        StaticMethodAndVariable.accountNumber = accountNumber;
    }
}
