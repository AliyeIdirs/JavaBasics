package com.unitedcoder.homework.basichomeworks;

import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

public class TaxCalculationProject {
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
        System.out.println("Please enter your annual salary only with numeric value: ");
        String annualSalary= input.nextLine();
            System.out.println("Please enter your tax filling status as 'single' or 'married': ");
            String fillingStatus = input.nextLine();
            if (NumberUtils.isNumber(annualSalary) && Double.parseDouble(annualSalary)>0) {
                double salary = Double.parseDouble(annualSalary);
                if (fillingStatus.equalsIgnoreCase("single")) {
                    if (salary >= 0 && salary <= 32000) {
                        System.out.printf("Your annual salary is %.3f $%n", salary);
                        System.out.println("Your tax filling status is: " + fillingStatus);
                        System.out.println("Your tax percentage is: 10%");
                        double tax1 = (salary) * 0.1;
                        System.out.printf("Your total tax is %.3f $%n", tax1);
                    } else {
                        System.out.printf("Your annual salary is %.3f $%n", salary);
                        System.out.println("Your tax filling status is: " + fillingStatus);
                        System.out.println("Your tax percentage is: 25%");
                        double tax1 = 32000 * 0.1;
                        double tax2 = (salary - 32000) * 0.25;
                        double totalTax = tax1 + tax2;
                        System.out.printf("Your total tax is %.3f $%n", totalTax);
                    }
                } else if (fillingStatus.equalsIgnoreCase("married")) {
                    if (salary >= 0 && salary <= 64000) {
                        System.out.printf("Your annual salary is %.3f $%n", salary);
                        System.out.println("Your tax filling status is: " + fillingStatus);
                        System.out.println("Your tax percentage is: 10%");
                        double tax1 = salary * 0.1;
                        System.out.printf("Your total tax is %.3f $%n", tax1);
                    } else {
                        System.out.printf("Your annual salary is %.3f $%n", salary);
                        System.out.println("Your tax filling status is: " + fillingStatus);
                        System.out.println("Your tax percentage is: 25%");
                        double tax1 = 64000 * 0.1;
                        double tax2 = (salary - 64000) * 0.25;
                        double totalTax = tax1 + tax2;
                        System.out.printf("Your total tax is %.3f $%n", totalTax);
                    }

                } else {
                    System.out.println("enter valid input");
                }
            }else {
                System.out.println("Please enter only positive numeric value!!!");
            }

    }
}

