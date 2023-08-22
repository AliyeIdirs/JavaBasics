package com.unitedcoder.conditions;

import java.util.Scanner;

public class SwitchCaseDemo2 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int month=input.nextInt();
        //3 4 5 -- Spring 6 7 8 --Summer
        switch (month){
            case 3:
            case 4:
            case 5:
                System.out.println("It is Spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("It is Summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("It is Fall");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("It is Winter");
                break;
        }
    }
}
