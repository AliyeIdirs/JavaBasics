package com.unitedcoder.javatpoint;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapInterface {
    public static void main(String[] args) {
        NavigableMap<Integer,String> map= new TreeMap<>();
        map.put(100,"Amit");
        map.put(102,"Ravi");
        map.put(101,"Vijay");
        map.put(103,"Rahul");

        //maintains ascending order
        System.out.println("ascendingMap: "+map);
        //print out descending order
        System.out.println("descendingMap: " +map.descendingMap());
        //returns key-value pairs whose keys are less than or equal to specified key
        System.out.println("headMap: "+map.headMap(102,true));
        //returns key-value pairs whose keys are greater than or equal to specified key
        System.out.println("tailMap: "+map.tailMap(102,true));
        //returns key-value pairs exists in between the specified key
        System.out.println("subMap: "+map.subMap(100,false,102,true));

    }
}
