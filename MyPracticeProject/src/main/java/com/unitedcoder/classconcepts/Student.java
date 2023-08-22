package com.unitedcoder.classconcepts;

public class Student {

    int id;
    String name;
    int rollno;
    void insertRecord(int r, String n){
        rollno=r;
        name=n;
    }
    void displayInformation(){
        System.out.println(rollno+" "+name);
    }
}


//Initialization through reference
class TestStudent1 {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.id = 101;
        s1.name = "Sonoo";
        System.out.println(s1.id + " " + s1.name);
    }
}


