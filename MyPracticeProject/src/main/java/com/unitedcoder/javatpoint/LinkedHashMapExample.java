package com.unitedcoder.javatpoint;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {

        //declaration a LinkedHashMap
        LinkedHashMap<Integer,String> hm=new LinkedHashMap<>();
        hm.put(100,"Amit");
        hm.put(101,"Vijay");
        hm.put(102,"Rahul");

        for (Map.Entry m:hm.entrySet()){
            System.out.println(m.getKey()+" "+ m.getValue());
        }

        //Key-Value pair
        LinkedHashMap<Integer,String> map=new LinkedHashMap<>();
        map.put(1,"Aliye");
        map.put(2,"Hakan");
        map.put(3,"Hatice");

        //Fetching key
        System.out.println("Keys:" +map.keySet());

        //Fetching value
        System.out.println("Value: "+map.values());

        //Fetching Key-Value pair
        System.out.println("Key-Value pairs: "+map.entrySet());

        //remove() method
        map.remove(3);
        System.out.println("After invoking remove() method:" +map);
    }
}
