package com.unitedcoder.classconcepts;

import com.beust.ah.A;

public class Account {
    int acc_no;
    String name;
    float amount;

    //Method to initialize Object
    void insert(int a, String n, float amt) {
        acc_no = a;
        name = n;
        amount = amt;
    }

    //deposit method
    void deposit(float amt) {
        amount = amount + amt;
        System.out.println(amt + " deposited");
    }

    //withdraw method
    void withdraw(float amt) {
        if (amt > amount) {
            System.out.println("Insufficient Balance");
        } else {
            amount = amount - amt;
            System.out.println(amt + " withdrawn");
        }
    }

    //method to check the balance of the account
    void checkBalance() {
        System.out.println("Balance is: " + amount);
    }

    //method to display the value of an object
    void display() {
        System.out.println("Account No: "+acc_no + "\nName: " + name + "\nInitial Amount: " + amount);
    }
}

    //creating a test class to deposit and withdraw amount
    class TestAccount{
        public static void main(String[] args) {
            Account a1= new Account();
            a1.insert(832345,"Ankit",1000);
            a1.display();
            a1.checkBalance();
            a1.deposit(40000);
            a1.checkBalance();
            a1.withdraw(5000);
            a1.checkBalance();
        }
    }
