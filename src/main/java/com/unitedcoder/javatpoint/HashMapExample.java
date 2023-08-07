package com.unitedcoder.javatpoint;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {

        //Example 1
        HashMap<Integer,String> map= new HashMap<>();
        map.put(1,"Mango");
        map.put(2,"Apple");
        map.put(3,"Banana");
        map.put(4,"Grapes");

        System.out.println("Iterating HashMap...");
        for (Map.Entry m :map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }

        //Example 2
        //no duplicate key on HashMap
        HashMap<Integer,String> map1= new HashMap<>();
        map1.put(1,"Onion");
        map1.put(2,"Pepper");
        map1.put(3,"Garlic");
        map1.put(1,"Eggplant"); //this value will replace the value "Onion"

        System.out.println("Iterating HashMap...");
        for(Map.Entry m1:map1.entrySet()){
            System.out.println(m1.getKey()+" "+ m1.getValue());
        }


        //Example 3
        //add() elements
        HashMap<Integer,String> hm= new HashMap<>();
        hm.put(100,"Amit");
        hm.put(101,"Vijay");
        hm.put(102,"Rahul");

        System.out.println("After invoking put method:");
        for(Map.Entry m2:hm.entrySet()){
            System.out.println(m2.getKey()+" "+m2.getValue());
        }

        hm.putIfAbsent(103,"Gaurav");
        System.out.println("After invoking putIfAbsent() method:");
        for(Map.Entry m3:hm.entrySet()){
            System.out.println(m3.getKey()+" "+m3.getValue());
        }

        HashMap<Integer,String> hm1=new HashMap<>();
        hm1.put(104,"Ravi");
        hm1.putAll(hm);
        System.out.println("After invoking putAll() method:");
        for(Map.Entry m4:hm1.entrySet()){
            System.out.println(m4.getKey()+" "+m4.getValue());
        }

    }
}
