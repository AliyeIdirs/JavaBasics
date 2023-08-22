package com.unitedcoder.lambdaandstream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamWithObject {
    public static void main(String[] args) {
        List<Employee> employees=getEmployee();

        //filter
        List<Employee> females=employees.stream()
                .filter(employee->employee.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        females.forEach(System.out::println);

        //sort
        List<Employee> sortedEmployees=employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .collect(Collectors.toList());
        sortedEmployees.forEach(System.out::println);

        List<Employee> salaryReverseSort=employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
        salaryReverseSort.forEach(System.out::println);

        //All match
        boolean allMatch=employees.stream().allMatch(employee -> employee.getAge()>30); //false, because not all ages are greater than 30
        System.out.println(allMatch);

        //Any match
        boolean anyMatch=employees.stream().anyMatch(employee ->employee.getAge()>35); //true
        System.out.println(anyMatch);

        //none match
        boolean noneMatch=employees.stream().noneMatch(employee -> employee.getName().equals("Anna"));
        System.out.println(noneMatch);

        //Max
        employees.stream().max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);

        //Mix
        employees.stream().min(Comparator.comparing(Employee::getAge))
                .ifPresent(System.out::println);


    }
    private static List<Employee> getEmployee(){
        List<Employee> employees= Arrays.asList(
                new Employee("Anna",25,Gender.FEMALE,7000),
                new Employee("Jhon",35,Gender.MALE,5000),
                new Employee("Helen",33,Gender.FEMALE,8000),
                new Employee("Alex",38,Gender.MALE,12000)
        );
        return employees;
    }
}
