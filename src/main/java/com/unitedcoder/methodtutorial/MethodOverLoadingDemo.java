package com.unitedcoder.methodtutorial;

public class MethodOverLoadingDemo {
    private int accountId;
    private String accountName;
    private double accountBalance;
    private String accountAddress;

    public MethodOverLoadingDemo(int accountId, String accountName, double accountBalance, String accountAddress) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
        this.accountAddress = accountAddress;
    }

    //method overloading is: if a class has multiple methods having same name but different in parameters

    public void printAccountInfo(int accountId){
        System.out.println("Account Id: "+accountId);
    }

    public void printAccountInfo(int accountId,String accountName){
        System.out.println("Account Id: "+accountId);
        System.out.println("Account Name: "+accountName);
    }

    public void printAccountInfo(int accountId, String accountName, double accountBalance){
        System.out.println("Account Id: "+accountId);
        System.out.println("Account Name: "+accountName);
        System.out.println("Account Balance: "+accountBalance);
    }

    public static void main(String[] args) {
        MethodOverLoadingDemo demo= new MethodOverLoadingDemo(1234,"User1",10000,"USA");
        demo.printAccountInfo(demo.getAccountId());
        System.out.println("----------------");
        demo.printAccountInfo(demo.getAccountId(),demo.getAccountName());
        System.out.println("----------------");
        demo.printAccountInfo(demo.getAccountId(),demo.getAccountName(),demo.getAccountBalance());
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

}
