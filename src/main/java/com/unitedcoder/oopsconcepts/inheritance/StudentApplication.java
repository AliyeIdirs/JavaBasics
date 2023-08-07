package com.unitedcoder.oopsconcepts.inheritance;

import java.util.Arrays;

public class StudentApplication {
    public static void main(String[] args) {
        System.out.println("Blows are Students Info:");
        Student student= new Student(101,"Mike","Smith","IT",23,
                "SDET","2000-6-15");
        System.out.println(student);

        System.out.println("Blows are Graduate Students Info");

        GraduateStudent graduateStudent= new GraduateStudent(201,"David","Jonson",
                "Java",20,"SDET","2002-8-5","Dolkun",
                "E-Commerce Application Testing");
        System.out.println(graduateStudent);

        System.out.println("Blows are Doctor Students Info:");
        DoctorStudent doctorStudent= new DoctorStudent(8765,"Emma","Clark",
                "ClassA",25, "Architect","1998-4-18","Aynigar",
                "Ancient Mosque", "Mosques in Istanbul", Arrays.asList("publicaiton1","publicaiton2"));
        System.out.println(doctorStudent);
    }
}
