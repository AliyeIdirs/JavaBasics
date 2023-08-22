package com.unitedcoder.javatpoint;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListvsLinkedList {
    public static void main(String[] args) {
        List<String> al=new ArrayList<>();
        al.add("Ravi");
        al.add("Vijay");
        al.add("Ravi");
        al.add("Ajay");

        List<String> al2=new LinkedList<>();
        al2.add("James");
        al2.add("Serena");
        al2.add("Swati");
        al2.add("Junaid");

        System.out.println("arrayList:" +al);
        System.out.println("linkedList:"+al2);
    }
}
