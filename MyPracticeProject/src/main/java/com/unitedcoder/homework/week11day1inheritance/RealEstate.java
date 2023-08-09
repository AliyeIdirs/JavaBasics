package com.unitedcoder.homework.week11day1inheritance;

public class RealEstate {
    private double price;
    private String locationCity;
    private String locationState;
    private double size;
    private String type;

    //default constructor
    public RealEstate() {
    }

    //parameterized constructor
    public RealEstate(double price, String locationCity, String locationState, double size, String type) {
        this.price = price;
        this.locationCity = locationCity;
        this.locationState = locationState;
        this.size = size;
        this.type = type;
    }

    //getter

    public double getPrice() {
        return price;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public String getLocationState() {
        return locationState;
    }

    public double getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    //to string method

    @Override
    public String toString() {
        return "Real Estate price: " + price + "\nlocationCity: " + locationCity +
                "\nlocationState: " + locationState + "\nsize: " + size + "\ntype: " + type;
    }
}
