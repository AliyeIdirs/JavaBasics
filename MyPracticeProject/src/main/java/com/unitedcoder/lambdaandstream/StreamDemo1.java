package com.unitedcoder.lambdaandstream;

import com.unitedcoder.cubecartautomation.LoginUser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo1 {
    public static void main(String[] args) {
        List<Integer> list1= Arrays.asList(1,5,45,89,34,87,78,90);
        //When using traditional for loop
       /* for(int i:list1){
            if(i%2==0){
                System.out.println(i);
            }
        }*/

        //When using stream
        list1.stream().filter(i-> i%2==0).forEach(i -> System.out.println(i));
        //we can give multiple conditions in stream
        list1.stream().filter(i-> i%2!=0).filter(i-> i>1).forEach(i-> System.out.println(i));

        List<String> customerList=Arrays.asList("customer1","Hakan","customer3","Edge","Markey");
        customerList.stream().filter(a -> a.length()>4 && a.length()<8).
                collect(Collectors.toList()).forEach(System.out::println);

        List<String> names=customerList.stream().filter(a->a.startsWith("c")).collect(Collectors.toList());
        System.out.println(names);

        //distinct
        List<String> vehicles = Arrays.asList("Car", "Bus", "Bike", "Car", "Bike","Bike");
        List<String> distinctVehicles = vehicles.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctVehicles);

        //limit
        List<String> limitedList=vehicles.stream().limit(4).collect(Collectors.toList());
        System.out.println(limitedList);

        //allMatch
        boolean allMatch=vehicles.stream().allMatch(s->s.equals("Bike"));
        System.out.println(allMatch);

        //anyMatch
        boolean anyMatch=vehicles.stream().anyMatch(s->s.equals("Bike"));
        System.out.println(anyMatch);

        //noneMatch
        boolean noneMatch=vehicles.stream().noneMatch(s->s.equals("Bom"));
        System.out.println(noneMatch);

    }
}
