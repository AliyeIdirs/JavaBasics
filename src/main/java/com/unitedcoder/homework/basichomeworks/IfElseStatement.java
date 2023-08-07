package com.unitedcoder.homework.basichomeworks;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class IfElseStatement {
    public static void main(String[] args) {
        Scanner input =new Scanner (System.in);
        System.out.println("Please choose your marital status below\n 'YES'\n'NO':");
        String maritalStatus= input.nextLine();
        System.out.println("Please enter your annual income only with numeric value:");
        String incomeS=input.nextLine();
        if (StringUtils.isNumeric(incomeS)) {
            int incomeI=Integer.parseInt(incomeS);
            if (maritalStatus.equalsIgnoreCase("no")){
                if (incomeI >=0 && incomeI <=32000){
                    System.out.println("Tax bracket is 10%");
                    double tax= incomeI* 0.1;
                    System.out.println("Your tax is "+tax);
                } else {
                    System.out.println("Tax bracket is 25%");
                    double tax= 3200 + (incomeI-32000)*0.25;
                    System.out.println("Your tax is "+tax);
                }

            } else if (maritalStatus.equalsIgnoreCase("yes")) {
                if (incomeI >= 0 && incomeI <=64000) {
                    System.out.println("Tax bracket is 10%");
                    double tax = incomeI * 0.1;
                    System.out.println("Your tax is " + tax);
                } else {
                    System.out.println("Tax bracket is 25%");
                    double tax = 6400 + (incomeI - 64000) * 0.25;
                    System.out.println("Your tax is " + tax);

                }

            } else{
                System.out.println("Please enter a valid marital status!!!");
            }
        }else {
            System.out.println("Please enter a valid income value!!!");
        }


    }
}
