package com.unitedcoder.conditions;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class SwitchCaseDemo {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("Please enter month with number:");
        String month=input.nextLine();
        if (StringUtils.isNumeric(month)) {

            switch (Integer.parseInt(month)) {
                case 1:
                    System.out.println("It is January");
                    break;
                case 2:
                    System.out.println("It is February");
                    break;
                case 3:
                    System.out.println("It is March");
                    break;
                case 4:
                    System.out.println("It is April");
                    break;
                case 5:
                    System.out.println("It is May");
                    break;
                case 6:
                    System.out.println("It is June");
                    break;
                case 7:
                    System.out.println("It is July");
                    break;
                case 8:
                    System.out.println("It is August");
                    break;
                case 9:
                    System.out.println("It is September");
                    break;
                case 10:
                    System.out.println("It is October");
                    break;
                case 11:
                    System.out.println("It is November");
                    break;
                case 12:
                    System.out.println("It is December");
                    break;

                default:
                    System.out.println("Please enter valid month between 1-12!");
            }
        } else{
            System.out.println("Please enter a valid numeric number for month!!!");
        }

    }
}
