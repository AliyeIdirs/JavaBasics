package com.unitedcoder.oopsconcepts.abstracttutorial;

public class TestBank {
    public static void main(String[] args) {
        Bank bank= new HSBCBank();
        bank.balance=1000;
        System.out.println(bank.amount);
        bank.loan();
        bank.credit();
        bank.debt();

        //we can also create object with HSBCBank class
        HSBCBank hscbBank= new HSBCBank();
        hscbBank.loan();
    }
}
