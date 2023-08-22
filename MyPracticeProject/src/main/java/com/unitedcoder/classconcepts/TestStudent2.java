package com.unitedcoder.classconcepts;

class TestStudent2 {

    //We can also create multiple objects and store information in it through reference variable.
    public static void main(String[] args) {
        Student s1= new Student();
        Student s2= new Student();
        s1.id=101;
        s1.name="Sonoo";
        s2.id=102;
        s2.name="Amit";
        System.out.println(s1.id+" "+s1.name);
        System.out.println(s2.id+" "+s2.name);
    }
}
