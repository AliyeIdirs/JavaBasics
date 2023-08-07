package com.unitedcoder.loops;

public class ForLoopDemo2 {
    public static void main(String[] args) {
        //1-10 sum
        int sum=0;
        for(int i=1; i<=10;i++){
            sum +=i; //sum = sum+i
            System.out.printf("i = %d sum = %d\n ",i,sum);
        }
        System.out.println("Total Sum: "+sum);
        // 1-5 factorial
        int factorial=1;
        for (int j=1; j<=5; j++){
            factorial *=j;
            System.out.printf("j= %d factorial= %d\n",j,factorial);
        }
        System.out.println("Factorial :"+factorial);

        //count even numbers
        int evenNumberCounts=0;
        for (int j=0; j<=100; j++){
            if (j!=0 && j%2==0){
                evenNumberCounts++;
            }
        }
        System.out.println("Total even number is: " +evenNumberCounts);
    }
}
