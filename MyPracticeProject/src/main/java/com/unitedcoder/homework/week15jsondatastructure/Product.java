package com.unitedcoder.homework.week15jsondatastructure;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    @JsonProperty("status")
    private boolean status;
    @JsonProperty("productName")
    private String productName;
    @JsonProperty("manufacturer")
    private String manufacturer;
    @JsonProperty("productCode")
    private String productCode;
    @JsonProperty("productWeight")
    private double productWeight;
    @JsonProperty("productWidth")
    private double productWidth;
    @JsonProperty("productHeight")
    private double productHeight;
    @JsonProperty("stockLevel")
    private int stockLevel;
    @JsonProperty("stockLevelWarning")
    private int stockLevelWarning;
    @JsonProperty("active")
    private boolean active;

    public Product() {
    }

    public Product(boolean status, String productName, String manufacturer, String productCode, double productWeight, double productWidth, double productHeight, int stockLevel, int stockLevelWarning, boolean active) {
        this.status = status;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.productCode = productCode;
        this.productWeight = productWeight;
        this.productWidth = productWidth;
        this.productHeight = productHeight;
        this.stockLevel = stockLevel;
        this.stockLevelWarning = stockLevelWarning;
        this.active = active;
    }

    public boolean isStatus() {
        return status;
    }

    public String getProductName() {
        return productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getProductCode() {
        return productCode;
    }

    public double getProductWeight() {
        return productWeight;
    }

    public double getProductWidth() {
        return productWidth;
    }

    public double getProductHeight() {
        return productHeight;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public int getStockLevelWarning() {
        return stockLevelWarning;
    }

    public boolean isActive() {
        return active;
    }
}
