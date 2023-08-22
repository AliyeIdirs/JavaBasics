package com.unitedcoder.javabasic;
import java.sql.SQLOutput;
import java.util.Scanner;

public class BreakingLoop {
    public static void main(String[] args) {
        //nested for loop with break
        Scanner inputLevels=new Scanner(System.in);
        System.out.println("Enter the number of levels: ");
        int levels=inputLevels.nextInt();
        System.out.println("You entered: "+levels);
        //infinite loop with break
        for (int i=1;;i++)
        {
            for (int j=1; j<=i; j++)
            {
                System.out.print("*");
            }
            System.out.println();
            if(i==levels)
                break;
        }

    }
}
