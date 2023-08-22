package com.unitedcoder.commandline;

public class CommandLineArgument1 {
    public static void main(String[] args) {
        for (String s : args) {
            System.out.println(s);
            System.out.println();
        }
    }
}
