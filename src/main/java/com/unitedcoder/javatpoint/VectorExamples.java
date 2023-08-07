package com.unitedcoder.javatpoint;

import java.util.Vector;

public class VectorExamples {
    public static void main(String[] args) {

        //Example 1
        System.out.println("Example 1:");
        Vector<String> vec=new Vector<>();
        vec.add("Tiger");
        vec.add("Lion");
        vec.add("Dog");
        vec.add("Elephant");

        //Adding elements using addElement() method
        vec.addElement("Rat");
        vec.addElement("Cat");
        vec.addElement("Deer");

        System.out.println("Elements are: "+vec);
        System.out.println("*********************************************************************************************");


        //Example 2
        System.out.println("Example 2: ");
        Vector<String> vec2=new Vector<>(4);
        vec2.add("Tiger");
        vec2.add("Lion");
        vec2.add("Dog");
        vec2.add("Elephant");
        System.out.println("Size is:" +vec2.size());
        System.out.println("Default capacity is:" +vec2.capacity());
        System.out.println("Vector elements are: "+vec2);

        vec2.addElement("Rat");
        vec2.addElement("Cat");
        vec2.addElement("Deer");
        System.out.println("Size after addition:" +vec2.size());
        System.out.println("Capacity after addition:" +vec2.capacity());
        System.out.println("Vector Elements after addition: " +vec2);

        if(vec.contains("Tiger")){
            System.out.println("Tiger is present at the index " +vec2.indexOf("Tiger"));
        }else{
            System.out.println("Tiger is not present in the list");
        }

        //get the first element
        System.out.println("The first animal of the vector is = "+vec2.firstElement());
        //get the last element
        System.out.println("The last animal of the vector is = "+vec2.lastElement());
        System.out.println("*********************************************************************************************");


        //Example 3
        System.out.println("Example 3:");
        Vector<Integer> in=new Vector<>();
        in.add(100);
        in.add(200);
        in.add(300);
        in.add(200);
        in.add(400);
        in.add(500);
        in.add(600);
        in.add(700);
        System.out.println("Values of Vector:"+in);
        System.out.println("Remove first occurrence of element 200:" +in.remove((Integer)200));
        System.out.println("Values in vector: "+in);
        //remove the element at index 4
        System.out.println("Remove element at index 4: "+ in.remove(4));
        System.out.println("Values of Vector:"+in);
        //remove an element
        in.removeElementAt(5);
        System.out.println("Vector elements after removal: "+in);
        //get the hashcode for this vector
        System.out.println("Hash code of this vector = "+in.hashCode());
        System.out.println("Element at index 1 is: " +in.elementAt(1));
        System.out.println("*********************************************************************************************");
    }
}
