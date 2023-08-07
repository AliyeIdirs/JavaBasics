package com.unitedcoder.homework.week11day2;

public class Student extends Person{
    private final String grade;
    private final String major;
    private final String schoolName;
    private final String schoolLocation;

    public Student(String grade, String major, String schoolName, String schoolLocation) {
        this.grade = grade;
        this.major = major;
        this.schoolName = schoolName;
        this.schoolLocation = schoolLocation;
    }

    public Student(String firstName, String lastName, String streetAddress, String city, String state, String country, String grade, String major, String schoolName, String schoolLocation) {
        super(firstName, lastName, streetAddress, city, state, country);
        this.grade = grade;
        this.major = major;
        this.schoolName = schoolName;
        this.schoolLocation = schoolLocation;
    }

    public String getGrade() {
        return grade;
    }

    public String getMajor() {
        return major;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getSchoolLocation() {
        return schoolLocation;
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", schoolLocation='" + schoolLocation + '\'' +
                '}';
    }
}
