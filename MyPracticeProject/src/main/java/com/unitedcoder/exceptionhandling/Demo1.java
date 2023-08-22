package com.unitedcoder.exceptionhandling;

public class Demo1 {
    //1. Conditional Statement: if() else()
    //2. try() catch()
    //3. try() catch() finally()
    //4. throws in method level
    //5. throw key word
    public static void main(String[] args) {
        //Thread.sleep(3000);  //compile time exception8"

        try {
            int[] a = {1, 3, 4, 5, 6};
            System.out.println(a[6]); // runtime exception
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("Hello World");
        }
    }
}
