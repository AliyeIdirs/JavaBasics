package com.unitedcoder.javatpoint;

import java.util.Hashtable;
import java.util.Map;

public class HashtableExample {
    public static void main(String[] args) {
        Hashtable<Integer,String> ht=new Hashtable<>();

        ht.put(100,"Amit");
        ht.put(102,"Ravi");
        ht.put(101,"Vijay");
        ht.put(103,"Rahul");

        for (Map.Entry m:ht.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }

        //remove()
        ht.remove(102);
        System.out.println(ht);

        //getOrDefault()
        ht.put(102,"Ravi");
        //Here, we specify the if and else statement as arguments of the method
        System.out.println(ht.getOrDefault(101,"Not Found"));
        System.out.println(ht.getOrDefault(105,"Not Found"));

        //putIfAbsent
        ht.putIfAbsent(104,"Gaurav");
        System.out.println("Updated Map:"+ ht);
        ht.putIfAbsent(101,"Vijay");
        System.out.println("Updated Map: "+ht);
    }
}
