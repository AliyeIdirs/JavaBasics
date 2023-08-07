package com.unitedcoder.homework.week13cubecartautomation;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Properties;

public class BaseFunctions {
    static final String separator=String.valueOf(File.separator);
    static final String configFile="config-qa.properties";
    static int timeout=Integer.parseInt(readConfigFile(configFile,"timeout"));
    static final String mainFolder="Week13_TestResults";
    static String testStatus="";
    static List<String[]> reportContent=new ArrayList<>();

    public static String readConfigFile(String fileName, String key){
        Properties properties=new Properties();
        String value="";
        try {
            properties.load(new FileInputStream(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        value=properties.getProperty(key);
        return value;
    }

    public static String getCurrentTime(){
        DateTime dateTime=new DateTime();
        DateTimeFormatter formatter= DateTimeFormat.forPattern("yyyy-MM-dd-HH:mm:ss:SS");
        return dateTime.toString(formatter);
    }
    public static String getCurrentUser(){
        String userName=System.getProperty("user.name");
        return userName;
    }
    public static String timeStamp(){
        long timeStamp= System.currentTimeMillis();
        String time=(Long.toString(timeStamp).toString().substring(10));
        return time;
    }

}
