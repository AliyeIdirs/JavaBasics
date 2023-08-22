package com.unitedcoder.javatpoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class SortCollectionsExample {
    public static void main(String[] args) {

        //Example 1--sorting objects in default order
        ArrayList<String> al=new ArrayList<>();
        al.add("Viru");
        al.add("Saurav");
        al.add("Mukesh");
        al.add("Tahir");

        Collections.sort(al);
        Iterator itr= al.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        //Example 2--Sorting objects is descending order
        Collections.sort(al,Collections.reverseOrder());
        Iterator i=al.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }

        //Example 3 -- Sort Wrapper class objects
        ArrayList arrayList=new ArrayList();
        arrayList.add(Integer.valueOf(201));
        arrayList.add(Integer.valueOf(101));
        arrayList.add(230); //internally will be converted into objects as Integer.valueOf(230)

        Collections.sort(arrayList);
        Iterator iterator=arrayList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
