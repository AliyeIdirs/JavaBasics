package com.unitedcoder.classconcepts;

 class Employee implements Comparable<Employee>{

     //initialization through a constructor
     int id;
     String name;
     float salary;
     private String department;
     private int age;

     public Employee() {
     }

     public Employee(int id, String name, float salary, String department, int age) {
         this.id = id;
         this.name = name;
         this.salary = salary;
         this.department = department;
         this.age = age;
     }

     public int getId() {
         return id;
     }

     public String getName() {
         return name;
     }

     public float getSalary() {
         return salary;
     }

     public String getDepartment() {
         return department;
     }

     public int getAge() {
         return age;
     }

     @Override
     public String toString() {
         return "Employee{" +
                 "id=" + id +
                 ", name='" + name + '\'' +
                 ", salary=" + salary +
                 ", department='" + department + '\'' +
                 ", age=" + age +
                 '}';
     }

     void insert(int i, String n, float s) {
         id = i;
         name = n;
         salary = s;
     }

     void display() {
         System.out.println(id + " " + name + " " + salary);
     }

     @Override
     public int compareTo(Employee employee) { //sort the employee object according to salary
         if (salary == employee.salary) {
             return 0;
         } else if (salary > employee.salary)
             return 1;
     else
         return -1;
    }
 }

      class TestEmployee {
         public static void main(String[] args) {
             Employee e1 = new Employee();
             Employee e2 = new Employee();
             Employee e3 = new Employee();
             e1.insert(101, "ajeet", 45000);
             e2.insert(102, "irfan", 25000);
             e3.insert(103, "nakul", 55000);
             e1.display();
             e2.display();
             e3.display();
         }
     }
