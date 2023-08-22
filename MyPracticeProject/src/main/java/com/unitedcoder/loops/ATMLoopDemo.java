package com.unitedcoder.loops;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class ATMLoopDemo {
    public static void main(String[] args) {
        int correctPin=1234;
        int balance=100000;
        //Pin number
        Scanner input=new Scanner(System.in);
        System.out.println("Please enter your PIN number:");
        int chance=3;
        int i= 0;
        do {
            String pin = input.nextLine();
            i++;
            if (StringUtils.isNumeric(pin) && Integer.parseInt(pin) == correctPin) {
                System.out.println("Please select the menu:\nTransfer money\nDeposit money\nWithdraw money\n");
                String selectedMenu = input.nextLine();
                System.out.println(selectedMenu);
                if (selectedMenu.equalsIgnoreCase("withdraw money")) {
                    System.out.println("Please enter withdraw amount:");
                    int withDrawAmount = input.nextInt();
                    if (withDrawAmount <= balance) {
                        System.out.println("Please take your money. Enjoy!!");
                        System.out.printf("Your current balance is %d", balance - withDrawAmount);
                    } else {
                        System.out.printf("Insufficient balance! your balance is %d,Please enter amount less than your balance", balance);

                    }
                } else if (selectedMenu.equalsIgnoreCase("deposit money")) {
                    System.out.println("Enter deposit amount");
                    int depositAmount = input.nextInt();
                    System.out.printf("Deposit is successful, Your current deposit is %d", balance + depositAmount);
                } else {
                    System.out.println("Please enter valid input!");
                }
                break;

            }
            System.out.printf("incorrect pin number, you have %d chance left\n", chance-i);

        }
            while (i<chance) ;


    }
}
