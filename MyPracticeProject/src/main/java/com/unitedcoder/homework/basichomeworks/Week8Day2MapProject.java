package com.unitedcoder.homework.basichomeworks;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Week8Day2MapProject {
    public static void main(String[] args) {
       /* Write a Java program with the following requirements.

        Use Java Map data structure store following information.
        Key	Value
        MD	Maryland
        VA	Virginia
        NY	New York
        Count the number of keys and print out the number
        Use for each loop, print out the key and value of each state.*/

        HashMap<String,String> map=new HashMap<>();
        map.put("MD","Maryland");
        map.put("VA","Virgina");
        map.put("NY","New York");
        int keyCount=0;
        //keySet
        Set<String> keys=map.keySet();
        for(String k:keys){
            keyCount++;
        }
        System.out.println("Number of Keys: " +keyCount);

        for(Map.Entry entry: map.entrySet()){
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }
    }
}
