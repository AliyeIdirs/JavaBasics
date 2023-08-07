package com.unitedcoder.loops;

public class LoopContinueDemo {
    public static void main(String[] args) {
        for (int i=1; i<10; i++){
            if (i % 4 == 0){
                continue; //when statement is true, it doesn't execute the code, back to the for loop

            }
            System.out.println(i);
        }

    }
}
