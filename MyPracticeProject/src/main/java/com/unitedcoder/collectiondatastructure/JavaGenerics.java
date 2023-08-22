package com.unitedcoder.collectiondatastructure;

import java.util.ArrayList;

public class JavaGenerics {
    public static void main(String[] args) {
        ArrayList list1= new ArrayList(); //list1 is an Object now
        list1.add(100);
        list1.add(90);
        list1.add(200);
        list1.add(300);

        for(java.lang.Object a:list1){
            System.out.println((Integer)a*2); //because list1 is an object, we convert it to Integer in order to do math operations
        }

        ArrayList<ArrayDemo2> list11=new ArrayList<>();
    }
}
