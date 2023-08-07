package com.unitedcoder.homework.week10day3method;

public class Product {
    private String name;
    private String category;
    private double price;

    public Product() {
    }

    public Product(String name, String category, Double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public void reducePrice(){
        Double reducedPrice=price-50;
        System.out.println("Reduced Price: "+reducedPrice);
    }

    public void increasePrice(){
        Double increasedPrice= price+50;
        System.out.println("Increased Price: "+increasedPrice);
    }
}
