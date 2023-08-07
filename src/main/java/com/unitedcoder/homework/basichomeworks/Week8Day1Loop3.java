package com.unitedcoder.homework.basichomeworks;

public class Week8Day1Loop3 {
    public static void main(String[] args) {
        int runTime=0;
        int restTime=0;
        int totalTime=0;
        int i=1;
           while(i<=25){
               runTime=runTime+15;
               restTime=restTime+5;
               totalTime=runTime+restTime;
               i++;

        }
        System.out.println("Run Time: " +runTime);
        System.out.println("Rest Time: " +restTime);
        System.out.println("Total Time: " +totalTime);
    }
}
