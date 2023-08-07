package com.unitedcoder.javatpoint;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample2 {
    public static void main(String[] args) {

        //remove() elements
        HashMap<Integer,String> map=new HashMap<>();
        map.put(100,"Aliye");
        map.put(101,"Hakan");
        map.put(102,"Zehra");
        map.put(103,"Emre");
        System.out.println("Initial list of elements:" +map);

        ///key-based removal
        map.remove(100);
        System.out.println("Updated list of elements: " +map);

        //value-based removal
        map.remove(101);
        System.out.println("Updated list of elements: " +map);

        //key-value pair based removal
        map.remove(102,"Zehra");
        System.out.println("Updated list of elements: "+map);


        //replace() elements
        HashMap<Integer,String> hm= new HashMap<>();
        hm.put(1,"Aliye");
        hm.put(2,"Hakan");
        hm.put(3,"Yasir");
        hm.put(4,"Ahsen");
        System.out.println("Initial list of elements:");
        for(Map.Entry m:hm.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }

        System.out.println("Updated list of elements:");
        hm.replace(3,"Enes");
        for(Map.Entry m:hm.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }

        System.out.println("Updated list of elements:");
        hm.replace(4,"Ahsen","Münevver");
        for (Map.Entry m:hm.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }

        System.out.println("Updated list of elements:");
        hm.replaceAll((k,v)->"Demir");
        for(Map.Entry m:hm.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
}
