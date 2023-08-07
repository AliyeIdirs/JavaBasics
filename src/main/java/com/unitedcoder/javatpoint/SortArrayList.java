package com.unitedcoder.javatpoint;

import java.util.*;

public class SortArrayList {
    public static void main(String[] args) {

        //sorting String
        List<String> list1=new ArrayList<>(); //using List interface
        list1.add("Mango");
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Grapes");
        //sorting the list
        Collections.sort(list1);
        for(String fruit:list1){
            System.out.print(fruit+" ");
        }
        System.out.println();


        //sorting number
        System.out.println("Sorting numbers...");
        List<Integer> list2=new ArrayList<>();
        list2.add(21);
        list2.add(11);
        list2.add(51);
        list2.add(1);
        Collections.sort(list2);
        for(Integer number:list2){
            System.out.print(number+" ");
        }
        System.out.println();

        ArrayList<String> list=new ArrayList<>();
        list.add("Ravi");
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");
        System.out.println("Traversing list through List Iterator");
        //Here, element iterates in reverse order
        ListIterator<String> iterator=list.listIterator(list.size());
        while(iterator.hasPrevious()){
            String str=iterator.previous();
            System.out.println(str);
        }

        System.out.println("Traversing list through for loop:");
        for(int i=0; i< list.size(); i++){
            System.out.println(list.get(i));
        }

        System.out.println("Traversing list through forEach() method:");
        list.forEach(a-> {//Here, we are using lambda expression
            System.out.println(a);
        });

        System.out.println("Traversing list through forEachRemaining() method:");
        Iterator<String> itr=list.iterator();
        itr.forEachRemaining(a-> //Here, we are using lambda expression
        {
            System.out.println(a);
        });
    }
}
