package com.unitedcoder.collectiondatastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListMethods {
    public static void main(String[] args) {
        //Two ways of creating an array list
        ArrayList<Integer> arrayList=new ArrayList<>(); //created from ArrayList<> Class
        List<Integer> list= new ArrayList<>(); //created from List<> Interface
        arrayList.add(200); //{200}
        arrayList.add(500); //{200,500}
        arrayList.add(100); //{200,500,100}

        //Size
        System.out.println(arrayList.size()); //3

        //get index
        System.out.println(arrayList.get(1)); //500
        System.out.println(arrayList);

        //No size limit in array list
        arrayList.add(400);//{200,500,100,400}
        arrayList.add(900);//{200,500,100,400,900}

        System.out.println(arrayList.get(4)); //900

        //array list maintains insertion order
        System.out.println(arrayList); //{200,500,100,400,900}

        //replace first index with another value
        arrayList.set(1,1000);
        System.out.println(arrayList); //{200,1000,100,400,900}

        //Sort array list in order
        Collections.sort(arrayList); //Collection class
        System.out.println(arrayList); //{100, 200, 400, 900, 1000}

        //Reverse elements in array list
        Collections.reverse(arrayList);
        System.out.println(arrayList); //{1000, 900, 400, 200, 100}

        //print out every element of array list with loop
        int sum=0;
        for (int i=0; i<arrayList.size();i++){
            sum +=arrayList.get(i);
            System.out.print(arrayList.get(i)+" "); //1000 900 400 200 100

        }
        System.out.println();
        System.out.println(sum); // 2600

        //remove an element from array list
        arrayList.remove(2);
        System.out.println(arrayList); //{1000, 900, 200, 100}

        //array list can have duplicate elements
        arrayList.add(900);
        System.out.println(arrayList); //{1000, 900, 200, 100,900}


        //we can add one array list to another array list
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(60); list1.add(80);
        list1.add(90); list1.add(100);

        ArrayList<Integer> list2=new ArrayList<>();
        list2.addAll(list1);
        System.out.println(list2); //{60, 80, 90, 100}

        //clear all elements of the array
        list2.clear();
        System.out.println(list2); //[]

        //find sum and average of an ArrayList
        Integer[] evenNumber= new Integer[]{2,4,6,8,8,2,8,10};
        ArrayList<Integer> numberArrayList=new ArrayList<>();
        Collections.addAll(numberArrayList,evenNumber);
        double totalSum=0;
        for(int number:numberArrayList){
            totalSum=number+totalSum;
        }
        System.out.println("Total number is: "+totalSum);
        System.out.println("Total items are: "+numberArrayList.size());
        System.out.println("Average number is: "+totalSum/numberArrayList.size());

        //find match
        System.out.println("----find match example----");
        int a=8;
        int totalMatch=0;
        for(int number:numberArrayList){
            if(number==a)
                totalMatch=totalMatch+1;
        }
        System.out.println("Total match is: "+totalMatch);
        if(totalMatch==0)
            System.out.println("No items is found with the value "+a);

        //find max and min number
        System.out.println("---Print Max Number---");
        int maxNumber=numberArrayList.get(0);
        for(int j=1; j<numberArrayList.size();j++){
            int nextNumber=numberArrayList.get(j);
            if(nextNumber>maxNumber)
                maxNumber=nextNumber;
        }
        System.out.println("Max number is: "+maxNumber);
        System.out.println(numberArrayList);

        System.out.println("---Print Min Number---");
        int minNumber=numberArrayList.get(0);
        for(int i=0; i<numberArrayList.size(); i++){
            int nextNumber=numberArrayList.get(i);
            if(nextNumber<minNumber)
                minNumber=nextNumber;
        }
        System.out.println("Min number is: "+minNumber);
    }
}
