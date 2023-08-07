package com.unitedcoder.homework.basichomeworks;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Week7Day2SwitchStatement {
    public static void main(String[] args) {
        Scanner input= new Scanner (System.in);
        System.out.println("please enter the notations below: \nA,2...10, J, Q, K, D, H, S, C");
        String notation=input.nextLine();
        if (StringUtils.isNumeric(notation)){
            int numeric=Integer.parseInt(notation);
            if(numeric>=2 && numeric<=10){
                System.out.println("Card Value");
            } else {
                System.out.println("Please only choose number between 2-10!!!");
            }
        } else {
            switch (notation.toUpperCase()) {
                case "A":
                    System.out.println("Ace");
                    break;
                case "J":
                    System.out.println("Jack");
                    break;
                case "Q":
                    System.out.println("Queen");
                    break;
                case "K":
                    System.out.println("King");
                    break;
                case "D":
                    System.out.println("Diamonds");
                    break;
                case "H":
                    System.out.println("Hear");
                    break;
                case "S":
                    System.out.println("Spade");
                    break;
                case "C":
                    System.out.println("Clubs");
                    break;
                default:
                    System.out.println("Please only choose a provided value !!!");
            }
        }
    }
}
