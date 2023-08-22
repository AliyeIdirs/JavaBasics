package com.unitedcoder.collectiondatastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DictionaryDemo {
    public static void main(String[] args) {
        Map<String,String> sites=new HashMap<>();
        sites.put("yahoo","www.yahoo.com");
        sites.put("google","www.google.com");
        sites.put("youtube","www.youtube.com");
        sites.put("cnn","www.cnn.com");
        sites.put("cnn","www.cnn.com"); //Map doesn't accept duplicated keys
        System.out.println(sites.get("yahoo")); //returns the Value, not key
        //print the size of the dictionary
        System.out.println("Total size in the dictionary: "+sites.size());

        //print all keys
        Set<String> siteKeys=sites.keySet();
        for(String i: siteKeys){
            String url=sites.get(i);  //this commands returns the Value of the key
            System.out.println("Site: "+i+" url: "+url);
        }

        for(Map.Entry m: sites.entrySet()){
            System.out.println(m.getKey()+":"+ m.getValue());
        }
    }
}
