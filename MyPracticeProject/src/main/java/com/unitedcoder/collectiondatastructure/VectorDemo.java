package com.unitedcoder.collectiondatastructure;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> fruits= new Vector<>(3); //initial capacity
        //Adding elements use add()
        fruits.add("Apple");
        fruits.add("Peach");
        fruits.add("Mango");
        fruits.remove(2);
        //check size and capacity
        System.out.println("Size is: "+fruits.size());
        System.out.println("Capacity is: "+fruits.capacity());

        //Adding more elements use addElement()
        fruits.addElement("fruit4");
        fruits.addElement("fruit5");
        fruits.addElement("fruit6");

        //recheck size and capacity
        System.out.println("Size is: "+fruits.size());
        System.out.println("Capacity is: "+fruits.capacity());

        //Display vector elements with enumeration
        Enumeration en=fruits.elements();
        System.out.println("Fruits: ");
        while(en.hasMoreElements()){
            System.out.print(en.nextElement()+" ");
        }
    }
}
