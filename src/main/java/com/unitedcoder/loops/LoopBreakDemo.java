package com.unitedcoder.loops;

public class LoopBreakDemo {
    public static void main(String[] args) {
        for (int i=0; i<10; i++){
            if (i==4){
                break;
            }
            System.out.println(i);
        }

        for (int j=1; j<10; j++){
            if (j % 4 == 0){
                break; //when statement is true, it doesn't execute the code, back to the for loop
            }
            System.out.println(j);
        }

    }
}
