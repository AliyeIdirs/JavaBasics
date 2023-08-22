package com.unitedcoder.classconcepts;

import java.util.ArrayList;

public class TestCar {
    public static void main(String[] args) {
        Car toyota= new Car();
        toyota.setBrand("Toyota");
        toyota.setMade("Japan");
        toyota.setColor("White");
        toyota.setYear(2022);
        toyota.setMileAge(1000);
        toyota.setPrice(35000);
        toyota.setEngineType("2.0");

        Car honda= new Car();
        honda.setBrand("Honda");
        honda.setMade("Japan");
        honda.setColor("Red");
        honda.setYear(2018);
        honda.setMileAge(0);
        honda.setPrice(400000);
        honda.setEngineType("2.5");

        Car benz= new Car();
        benz.setBrand("Benz");
        benz.setMade("Germany");
        benz.setColor("Black");
        benz.setYear(2023);
        benz.setMileAge(0);
        benz.setPrice(1000000);
        benz.setEngineType("3.0");

        System.out.println(toyota.getBrand());
        System.out.println(honda.getBrand());
        System.out.println(benz.getBrand());

        System.out.println(toyota.getColor());
        System.out.println(honda.getColor());
        System.out.println(benz.getColor());

        System.out.println(toyota);

        ArrayList<Car> carList= new ArrayList<>();
        carList.add(toyota);
        carList.add(honda);
        carList.add(benz);
        for(Car cars:carList) {
            if (cars.getBrand().equalsIgnoreCase("honda")) {
                System.out.printf("%s: %s, %s, %d, %d, %d, %s%n",
                        cars.getBrand(),
                        cars.getColor(),
                        cars.getMade(),
                        cars.getPrice(),
                        cars.getMileAge(),
                        cars.getYear(),
                        cars.getEngineType());
            }
        }

        System.out.println(benz.carInfo());
    }
}
