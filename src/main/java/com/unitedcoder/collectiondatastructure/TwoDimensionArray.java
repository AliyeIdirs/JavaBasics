package com.unitedcoder.collectiondatastructure;

public class TwoDimensionArray {
    public static void main(String[] args) {
        int[][] a1= new int[4][];
        //int[] a1[]={1,4,5,6,9}
        int[][]array={
                {1,2,3},
                {6,9,10,70},
                {30,90},
                {20,80,30,5,8,10}
        };
        System.out.println(array.length); //4
        System.out.println(array[0].length); //3
        System.out.println(array[1].length); //4
        System.out.println(array[2].length); //2
        System.out.println(array[3].length); //6
        System.out.println(array[1][1]); //9
        System.out.println(array[3][2]); //30
        System.out.println(array[2][1]); //90
        System.out.println("********************");
        // find sum of all elements
        int sum=0;
        for(int i=0; i<array.length;i++){
            for(int j=0; j<array[i].length; j++){
                System.out.print(array[i][j]+" ");
                sum+=array[i][j];
            }
            System.out.println();
            System.out.println("Each Sum: "+sum);
        }
        System.out.println("Total Sum of array is: "+sum);
    }
}
