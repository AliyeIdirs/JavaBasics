package com.unitedcoder.commandline;

public class CommandLineArgument {
    public static void main(String[] args) {
        for (String s: args){
            System.out.println("The number is: "+s);
            int i=Integer.parseInt(s);
            if(i%2== 0){
                System.out.println("The number "+i+" is an even number");
            }
            else{
                System.out.println("The number "+i+" is an odd number");
            }
        }
    }
}
