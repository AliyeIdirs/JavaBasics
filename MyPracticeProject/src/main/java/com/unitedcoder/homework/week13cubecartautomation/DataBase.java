package com.unitedcoder.homework.week13cubecartautomation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataBase extends Methods{
    public static String priceChangeAction(){
        List<String> actionOptions=new ArrayList<>(Arrays.asList("Subtract","Add","Set to"));
        Random randomAction=new Random();
        String result=actionOptions.get(randomAction.nextInt(actionOptions.size()));
        return result;
    }
    public static int priceAmount(){
        int price=(int)(Math.random()*1000+10);
        return price;
    }
    public static String priceOption(){
        List<String> options=new ArrayList<>(Arrays.asList("all","price","sale_price","cost_price"));
        Random randomOption=new Random();
        String result=options.get(randomOption.nextInt(options.size()));
        return result;
    }

    public static List<String> reviewContent() {
        List<String> contents = new ArrayList<>(Arrays.asList("Name" + timeStamp(), "email" + timeStamp() + "@gmail.com"
                , "Title" + timeStamp(), "Super cute and very flattering! The material is durable and feels of good quality. " +
                        "I will say that I purchased a XL and while it mostly fit, it was still a little tight in" +
                        " the back so I had to return it." + timeStamp(), String.valueOf((int) (Math.random() * 5 + 1))));
        return contents;
    }

}
