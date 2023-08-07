package com.unitedcoder.objects;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Student {
    @JacksonXmlProperty(isAttribute = true)
    private int id;
    @JacksonXmlProperty(localName = "firstname")
    private String firstname;
    @JacksonXmlProperty(localName = "lastname")
    private String lastName;
    @JacksonXmlProperty(localName = "major")
    private String major;
    @JacksonXmlProperty(localName = "department")
    private String department;


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Student() {
    }

    public Student(int id, String firstname, String lastName, String major, String department) {
        this.id = id;
        this.firstname = firstname;
        this.lastName = lastName;
        this.major = major;
        this.department = department;
    }
}
