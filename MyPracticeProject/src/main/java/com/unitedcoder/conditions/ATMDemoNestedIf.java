package com.unitedcoder.conditions;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class ATMDemoNestedIf {
    public static void main(String[] args) {
        int correctPin=1234;
        int balance=100000;
        //Pin number
        Scanner input=new Scanner(System.in);
        System.out.println("Please enter your PIN number:");
        String pin=input.nextLine();
        if (StringUtils.isNumeric(pin)) {
            if(Integer.parseInt(pin)==correctPin) {
                System.out.println("Please select the menu:\nTransfer money\nDeposit money\nWithdraw money\n");
                String selectedMenu = input.nextLine();
                System.out.println(selectedMenu);
                if(selectedMenu.equalsIgnoreCase("withdraw money")) {
                    System.out.println("Please enter withdraw amount:");
                    int withDrawAmount = input.nextInt();
                    if (withDrawAmount <= balance) {
                        System.out.println("Please take your money. Enjoy!!");
                        System.out.printf("Your current balance is %d",balance - withDrawAmount);
                    } else {
                        System.out.printf("Insufficient balance! your balance is %d,Please enter amount less than your balance", balance);

                    }
                }else if(selectedMenu.equalsIgnoreCase("deposit money")){
                    System.out.println("Enter deposit amount");
                    int depositAmount=input.nextInt();
                    System.out.printf("Deposit is successful, Your current deposit is %d",balance+depositAmount);
                }
            }else {
                    System.out.println("You entered wrong PIN number!");
                    System.out.println("Please try again with correct 4 digit PIN number");
                }

        }else {
            System.out.println("Please enter only numeric number");

        }


    }
}
