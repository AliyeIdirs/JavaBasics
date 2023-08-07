package com.unitedcoder.classconcepts;

class TestStudent3 {
    public static void main(String[] args) {

        //initialization though method
        Student s1 = new Student();
        Student s2 = new Student();
        s1.insertRecord(111,"Karan");
        s2.insertRecord(222,"Aryan");
        s1.displayInformation();
        s2.displayInformation();
    }
}
