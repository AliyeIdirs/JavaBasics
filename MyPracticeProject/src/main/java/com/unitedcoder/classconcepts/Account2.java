package com.unitedcoder.classconcepts;

public class Account2 {
    private int acc_no;
    private String name;
    private float amount;

    public int getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(int acc_no) {
        this.acc_no = acc_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }


    //default constructor
    public Account2() {
    }

    //constructor with parameters
    public Account2(int acc_no, String name, float amount) {
        this.acc_no = acc_no;
        this.name = name;
        this.amount = amount;
    }
}


class TestAccount2{
    public static void main(String[] args) {
        Account2 account2= new Account2();
        account2.setAcc_no(832345);
        account2.setName("Ankit");
        account2.setAmount(1000);
        System.out.println("Account No: "+account2.getAcc_no());
        System.out.println("Name: "+account2.getName());
        System.out.println("Amount: "+account2.getAmount());

        Account2 account22= new Account2(234567,"Aliye",50000);
        System.out.println("Account No: "+account22.getAcc_no());
        System.out.println("Name: "+account22.getName());
        System.out.println("Amount: "+account22.getAmount());
    }
}
