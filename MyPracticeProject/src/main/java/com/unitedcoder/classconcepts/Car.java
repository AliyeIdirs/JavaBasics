package com.unitedcoder.classconcepts;

public class Car {
    // state - behavior
    //class level variable
    private String brand; //Honda, Toyota
    private String made;
    private String color;
    private long mileAge;
    private long price;
    private long year;

    private String engineType;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public String getColor() {
        return color;
    }



    public void setColor(String color) {
        this.color = color;
    }

    public long getMileAge() {
        return mileAge;
    }

    public void setMileAge(long mileAge) {
        this.mileAge = mileAge;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
    @Override
    public String toString() { //method overriding
        return "Car{" +
                "brand='" + brand + '\'' +
                ", made='" + made + '\'' +
                ", color='" + color + '\'' +
                ", mileAge=" + mileAge +
                ", price=" + price +
                ", year=" + year +
                ", engineType='" + engineType + '\'' +
                '}';
    }

        public String carInfo() {
            return brand+": " +made +", "+color+"," +mileAge+"," + price +"," +year+"," +engineType;
        }
    }
