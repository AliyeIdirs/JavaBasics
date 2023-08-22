package com.unitedcoder.collectiondatastructure;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionDemo {

    final static String zipcodePattern= "\\b[0-9]{5}(?:-[0-9]{4})?\\b";
    //UserIdPattern= "userid_[0-9]{1,2}_[0-9]{1,2}_[0-9]{4}_[0-9]{5}"
    //userid_4_23_2005_85083
    private static final String UserIdPattern="userid_[0-9]{1,2}_[0-9]{1,2}_[0-9]{4}_[0-9]{5}";

    public static void main(String[] args) {
        Pattern zipCodePattern;
        Matcher zipCodeMatcher;
        zipCodePattern= Pattern.compile(zipcodePattern);
        String zipCode= "21045-12346";
        zipCodeMatcher =zipCodePattern.matcher(zipCode);
        if(zipCodeMatcher.matches()){
            System.out.printf("Zip Code: %s is valid.%n",zipCode);
        }else{
            System.out.printf("Zip Code %s is Not a valid Zip code.%n",zipCode);
        }

        String[] userIds= new String[]{"userid_4_23_2005_85083", "userid_11_13_2000_312",
                "userid_8_27_2014_83046", "userid_12_24_2006_63060", "userid_9_8_2000_56086",
                "userid_7_7_2005_30338", "userid_10_15_2006_5493", "userid_9_14_2014_65",
                "userid_1_30_2010_475", "userid_2_1_2004_58032", "userid_8_4_2010_26849",
                "userid_10_19_2012_23906", "userid_5_29_2004_408", "userid_6_6_2011_82682",
                "userid_6_13_2005_32055", "userid_12_17_2013_76612", "userid_3_22_2001_41024",
                "userid_12_3_2010_51", "userid_4_13_2002_504", "userid_9_25_2014_10160",
                "userid_5_9_2009_18337", "userid_4_8_2002_427", "userid_5_29_2003_370",
                "userid_12_16_2002_972"};

        Pattern userPattern;
        Matcher userMatcher;
        userPattern=Pattern.compile(UserIdPattern);
        int notMatchCount=0;
        for(String userId:userIds){
            userMatcher= userPattern.matcher(userId);
            if(userMatcher.matches()){
                System.out.println(userId +" Matches.");
            }else{
                System.out.println(userId +" do not match.");
                notMatchCount=notMatchCount+1;
            }
        }
        System.out.println("Does not match count: "+notMatchCount);
    }
}
