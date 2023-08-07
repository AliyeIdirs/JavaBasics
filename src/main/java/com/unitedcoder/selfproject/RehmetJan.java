package com.unitedcoder.selfproject;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.arch.Processor;
import org.apache.commons.lang3.math.NumberUtils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Scanner;

    public class RehmetJan {
        public static void main(String[] args) throws ParseException {
            String s = "Single";
            String m = "Married";

            System.out.println("Pelase enter your state: ");
            Scanner scan = new Scanner(System.in);
            String status = scan.nextLine();
            String mySalary ;
            double annualSalary = 0.0;
            if (!StringUtils.isNumeric(status) && !status.contains("-")){
                switch (status.toLowerCase()){
                    case "single":
                        System.out.println("please enter your annual salary:");
                        mySalary = scan.nextLine();
                        if (mySalary.contains("-") | mySalary.isEmpty() | mySalary.isBlank() | StringUtils.isAlpha(mySalary)){
                            System.out.println("Invalid input : please enter abs digid number ");
                        }else {
                            if (mySalary.contains(",")| mySalary.contains("."))
                                annualSalary = DecimalFormat.getNumberInstance().parse(mySalary).doubleValue();
                            else {
                                annualSalary = Double.parseDouble(mySalary);
                                System.out.printf("Your Annual salary is %.2f " + annualSalary + "%n");
                            }
                            if (annualSalary <= 32000){
                                System.out.printf("you need to pay 10 percent tax , you tax based on your salary is %.2f:%n",annualSalary*0.1);
                            }else {
                                System.out.printf("Your salary is gereter than 32000 , so you need to pay 25 percent tax , your total tax is %.2f %n",annualSalary*0.25);
                            }
                        }
                        break;
                    case "married":
                        System.out.println("please enter your annual salary:");
                        mySalary = scan.nextLine();
                        if (mySalary.contains("-") | mySalary.isEmpty() | mySalary.isBlank() | !StringUtils.isNumeric(mySalary) | mySalary instanceof String){
                            System.out.println("Invalid input : please enter abs integer number ");
                        }else {
                            annualSalary = Double.parseDouble(mySalary);
                            System.out.println("Your Annual salary is " + annualSalary);
                            if (annualSalary <= 64000){
                                System.out.printf("you need to pay 10 percent tax , you tax based on your salary is %.2f:%n",annualSalary*0.1);
                            }else {
                                System.out.printf("Your salary is gereter than 32000 , so you need to pay 25 percent tax , your total tax is %.2f %n",annualSalary*0.25);
                            }
                        }
                        break;
                    default:
                        System.out.println("Please enter correct status with single or married !!!!! ");

                }
            }else {
                System.out.println("Wrong : Please enter your actually status !!!!!!!!");
            }
        }
    }
