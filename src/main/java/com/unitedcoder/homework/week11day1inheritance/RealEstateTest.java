package com.unitedcoder.homework.week11day1inheritance;

import java.util.Arrays;

public class RealEstateTest {
    public static void main(String[] args) {

        RealEstate realEstate=new RealEstate(1500000,"Los-Angles","California",
                1000,"Residential");

        System.out.println(realEstate);

        System.out.println("*******************************");

        CommercialRealEstate commercialRealEstate1= new CommercialRealEstate("Raw Land",
                10000, Arrays.asList("farm land", "warehouses", "garages"));

        System.out.println(commercialRealEstate1.toString1());

        System.out.println("*******************************");

        CommercialRealEstate commercialRealEstate2= new CommercialRealEstate(3000000,"New York","New York",20000,
                "Commercial","Industrial",10000, Arrays.asList("office buildings","medical centers","hotels","malls"));

        System.out.println(commercialRealEstate2);

    }

}
