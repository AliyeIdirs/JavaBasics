package com.unitedcoder.collectiondatastructure;

public class ArrayDemo {
    public static void main(String[] args) {

        int[] numberArrayExample1= new int[10]; //all elements are initialized with zero
        numberArrayExample1[0]=1;
        numberArrayExample1[1]=2;
        numberArrayExample1[2]=3;
        numberArrayExample1[3]=4;
        numberArrayExample1[5]=10;
        System.out.println("The number of items in the array numbers: "+numberArrayExample1.length);
        for(int number: numberArrayExample1){
            System.out.print(number+",");
        }
        System.out.println();

        System.out.println("\nString Array Example..................");
        String[] stringArrayExample1 = new String[4]; //all elements are initialized with null
        stringArrayExample1[0]="Mike";
        stringArrayExample1[1]="Robert";
        stringArrayExample1[2]="Smith";
        System.out.println("The number of items in the array names: "+stringArrayExample1.length);
        for(String names:stringArrayExample1){
            System.out.print(names+", ");
        }
        System.out.println();
        System.out.println("\nNumber Array Example 2");

        //initialize arrays with initial values
        int[] numberArrayExample2=new int[]{1,3,5,7,9};
        System.out.println("The number of items in the array numbers: "+numberArrayExample2.length);
        for(int number:numberArrayExample2){
            System.out.print(number +",");
        }
        System.out.println();
        String[] stringArrayExample2= new String[]{"A","B","C","D"};
        System.out.println("The number of items in the array string: " +stringArrayExample2.length);
        for(String name:stringArrayExample2){
            System.out.print(name +",");
        }

        System.out.println();
        System.out.println("Two-Dimensional Array----------");
        //two-dimensional arrays
        int row=3;
        int column=4;
        String[][] seats= new String[row][column];
        seats[0][0]="Mike";
        seats[0][1]="Bob";
        seats[0][2]="Emily";
        seats[0][3]="Jake";
        for(int r=0; r<row; r++){
            for(int c=0; c<column; c++){
                //if we do not use this line, this code will returns null for unassigned seats
                if(seats[r][c]==null){
                    seats[r][c]="no one";
                }
                System.out.println("row "+r+" column "+c+" assigned to " +seats[r][c]);
            }
        }

    }
}
