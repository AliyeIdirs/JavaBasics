package com.unitedcoder.collectiondatastructure;

import net.bytebuddy.build.Plugin;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>(); //Using Set Interface
        HashSet<Integer> set2=new HashSet<>(); //Using HashSet Class
        set2.add(100);          set2.add(200);
        set2.add(300);          set2.add(50);
        set2.add(70);           set2.add(20);
        set2.add(50); //HashSet doesnt accept duplicate element
        System.out.println(set2);

        //LinkedList maintains the insertion order
        LinkedList<Integer> list=new LinkedList<>(); //Using HashSet Class
        list.add(100);           list.add(200);
        list.add(300);           list.add(50);
        list.add(70);            list.add(20);
        list.add(50); //LinkedList accepts duplicate element
        System.out.println(list);

        //print out each element of a set using foreach loop
        int sum=0;
        for (int s:set2){
            System.out.print(s +" ");
            sum+=s;
        }
        System.out.println();
        System.out.println("Sum is: " +sum);
        System.out.println();
        //print out each element of a set using Iterator interface
        Iterator<Integer> itr= set2.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
        System.out.println();
        //convert set to object array
        Object[] array=set2.toArray();
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }


    }
}
