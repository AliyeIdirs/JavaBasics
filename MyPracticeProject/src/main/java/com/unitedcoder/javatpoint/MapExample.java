package com.unitedcoder.javatpoint;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        //Example 1:
        //Non-generic
        Map map=new HashMap();

        //Adding elements to map
        map.put(1,"Amit");
        map.put(5,"Rahul");
        map.put(2,"Jai");
        map.put(6,"Amit");

        //Traversing Map
        Set set=map.entrySet();  //Converting to Set so that we can traverse
        Iterator itr=set.iterator();
        while(itr.hasNext()){
            Map.Entry entry=(Map.Entry)itr.next();//Converting to Map.Entry so that we can get key and value separately

            System.out.println(entry.getKey()+" "+entry.getValue());
        }


        //Example 2:
        //Generic (New Style)
        Map<Integer,String> map1= new HashMap<Integer,String>();
        map1.put(100,"Amit");
        map1.put(101,"Vijay");
        map1.put(102,"Rahul");

        //Elements can traverse in any order
        for(Map.Entry m:map1.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }


        //Example 3:
        //comparing ByKey()
        Map<Integer,String> map2=new HashMap<Integer,String>();
        map2.put(100,"Amit");
        map2.put(101,"Vijay");
        map2.put(102,"Rahul");
        //returns a Set view of the mappings contained in this map
        map2.entrySet()
        //Returns a sequential Stream with this collection as its source
        .stream()
                //Sorted according to the provided Comparator
                .sorted(Map.Entry.comparingByKey())
                //Performs an action for each element of this stream
                .forEach(System.out::println);

        //comparingByKey() in Descending order
        map2.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(System.out::println);

        //comparingByValue()
        map2.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        //comparingByValue() in Descending order
        map2.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println); //it compares the alphabetic value order, not key order
    }
}
