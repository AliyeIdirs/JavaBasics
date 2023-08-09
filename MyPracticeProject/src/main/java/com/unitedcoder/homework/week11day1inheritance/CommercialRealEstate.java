package com.unitedcoder.homework.week11day1inheritance;

import java.util.List;

public class CommercialRealEstate extends RealEstate{
    private  String businessType;
    private double businessSize;

    private List<String> commercialProperties;

    //default constructor
    public CommercialRealEstate() {
    }

    //parameterized constructor only with this class's parameters
    public CommercialRealEstate(String businessType, double businessSize, List<String> commercialProperties) {
        this.businessType = businessType;
        this.businessSize = businessSize;
        this.commercialProperties = commercialProperties;
    }

    //parameterized constructor with both super class and this class parameters

    public CommercialRealEstate(double price, String locationCity, String locationState,
                                double size, String type, String businessType, double businessSize,
                                List<String> commercialProperties) {
        super(price, locationCity, locationState, size, type);
        this.businessType = businessType;
        this.businessSize = businessSize;
        this.commercialProperties = commercialProperties;
    }

    //to string method
    public String toString1() {
        return "Business Type: "+businessType+
                "\nBusiness Size: "+businessSize+ "\nCommercial Properties: "+commercialProperties;
    }

    @Override
    public String toString() {
        return super.toString() +"\n Business Type: "+businessType+
                "\nBusiness Size: "+businessSize+ "\nCommercial Properties: "+commercialProperties;
    }
}
