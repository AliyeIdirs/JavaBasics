package com.unitedcoder.lambdaandstream;

public class Employee {
    private String name;
    private int age;
    private Gender gender;
    private long salary;

    public Employee() {
    }

    public Employee(String name, int age, Gender gender, long salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public long getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", salary=" + salary +
                '}';
    }
}
