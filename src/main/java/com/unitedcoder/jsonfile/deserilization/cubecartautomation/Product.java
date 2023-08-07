package com.unitedcoder.jsonfile.deserilization.cubecartautomation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    @JsonProperty("product-name")
    private String productName;
    @JsonProperty("product-code")
    private String productCode;
    @JsonProperty("manufacturer")
    private String manufacturer;
    @JsonProperty("category")
    private String category;

    public Product() {
    }

    public Product(String productName, String productCode, String manufacturer, String category) {
        this.productName = productName;
        this.productCode = productCode;
        this.manufacturer = manufacturer;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCategory() {
        return category;
    }
}
