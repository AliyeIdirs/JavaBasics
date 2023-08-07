package com.unitedcoder.selfproject;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

public class TaxCalculationSwitch {
    public static void main(String[] args) {
    /*  1. Using Java nested conditional statement, implement a java code for the Federal Tax Rate Schedule
        in 2008. Below is the requirement.
        1. Enter the annual salary and tax filing status from the console;
        2. If your tax filing status is single, pay 10% tax for the annual salary between $0 - $32,000;
        pay 25% tax for the annual salary over $32,000;
        3. If your tax filing status is married, pay 10% tax for the annual salary between $0 - $64,000;
        pay 25% tax for the annual salary over $64,000;
        4. You need to print out the annual salary, tax filing status, tax percentage, and total tax on
        the console.*/
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your annual salary only with valid numeric value: ");
        String annualSalary = input.nextLine();
        System.out.println("Please choose tax filling status as:\nA=single\nB= married\n(Note: Only choose as A or B)");
        String fillingStatus = input.nextLine();
        if (NumberUtils.isNumber(annualSalary) && Double.parseDouble(annualSalary)>0) {
            double salary = Double.parseDouble(annualSalary);
            switch (fillingStatus.toUpperCase()) {
                case "A":
                    if (salary >= 0 && salary <= 32000) {
                        System.out.printf("Your annual salary is %.3f $%n", salary);
                        System.out.println("Your tax filling status is: Single ");
                        System.out.println("Your tax percentage is: 10%");
                        double tax1 = salary * 0.1;
                        System.out.printf("Your total tax is %.3f $%n", tax1);
                    } else {
                        System.out.printf("Your annual salary is %.3f $%n", salary);
                        System.out.println("Your tax filling status is: Single");
                        System.out.println("Your tax percentage is: 25%");
                        double tax1 = 32000 * 0.1;
                        double tax2 = (salary - 32000) * 0.25;
                        double totalTax = tax1 + tax2;
                        System.out.printf("Your total tax is %.3f $%n", totalTax);
                    }
                    break;
                case "B":
                    if (salary >= 0 && salary <= 64000) {
                        System.out.printf("Your annual salary is %.3f $%n", salary);
                        System.out.println("Your tax filling status is: Marries");
                        System.out.println("Your tax percentage is: 10%");
                        double tax1 = salary * 0.1;
                        System.out.printf("Your total tax is %.3f $%n", tax1);
                    } else {
                        System.out.printf("Your annual salary is %.3f $%n", salary);
                        System.out.println("Your tax filling status is: Married");
                        System.out.println("Your tax percentage is: 25%");
                        double tax1 = 64000 * 0.1;
                        double tax2 = (salary - 64000) * 0.25;
                        double totalTax = tax1 + tax2;
                        System.out.printf("Your total tax is %.3f $%n", totalTax);
                    }
                    break;
                default:
                    System.out.println("Please choose a valid status!");
                    break;
            }
        } else {
            System.out.println("Please enter salary only with positive numeric value!!!");
        }

    }
}

