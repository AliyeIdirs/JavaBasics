package com.unitedcoder.exceptionhandling;

public class Demo4 {
    public static void main(String[] args) {
        try {
            String s = "A123";
            int x = Integer.parseInt(s);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }finally {
            System.out.println("Java Exception");
        }

        //we can use try() finally() without catch
        try{
            String s = "A123";
            int x = Integer.parseInt(s);
        }
        finally{
            System.out.println("always run this block");
        }
    }
}
