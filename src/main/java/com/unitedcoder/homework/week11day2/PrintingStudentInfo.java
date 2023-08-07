package com.unitedcoder.homework.week11day2;

import java.util.ArrayList;

public class PrintingStudentInfo {
    public static void main(String[] args) {

        Student student1 = new Student("A", "Civil Engineer", "California University", "LA,USA");
        Person student2 = new Student("Laura", "Smith", "WallStreet No.10", "New York", "New York", "USA", "A+", "Economics", "City Univeristy", "Wall Street No.10");
        ArrayList<Object> studentList=new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        System.out.println(studentList);
        System.out.println(studentList.get(0));
        System.out.println(studentList.get(1));
        System.out.println(student1);
    }
}
