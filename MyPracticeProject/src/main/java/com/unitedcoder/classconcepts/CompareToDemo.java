package com.unitedcoder.classconcepts;

import org.apache.commons.compress.archivers.ar.ArArchiveEntry;

import java.util.*;

public class CompareToDemo {
    public static void main(String[] args) {
        List<Integer> list1= Arrays.asList(10,100,20,80,40,300);
        List<String> list2=Arrays.asList("Name","Age","Salary","Department");
        Collections.sort(list1);
        Collections.sort(list2);
        System.out.println(list1);
        System.out.println(list2);

        List<Employee> employeeList=new ArrayList<>();
        Employee employee1=new Employee(1,"Mike",8000,"IT",28);
        Employee employee2=new Employee(2,"David",5000,"HR",35);
        Employee employee3=new Employee(3,"Sara",10000,"Sales",45);
        Employee employee4=new Employee(4,"Laura",2500,"Export",19);
        employeeList.addAll(Arrays.asList(employee1,employee2,employee3,employee4));

        //when Employee Class does not implement Comparable interface
        //We need to give the condition here
        employeeList.sort(Comparator.comparing(Employee::getAge));
        System.out.println(employeeList);
        employeeList.sort(Comparator.comparing(Employee::getSalary));
        System.out.println(employeeList);
        //To comparing in reversed order
        employeeList.sort(Comparator.comparing(Employee::getSalary).reversed());
        System.out.println(employeeList);
        employeeList.sort(Comparator.comparing(Employee::getName));
        System.out.println(employeeList);

        //When Employee Class implements Comparable interface
        //we give the condition in Employee class, therefore directly use sort method of Collections
        Collections.sort(employeeList);
        System.out.println(employeeList);




    }
}
