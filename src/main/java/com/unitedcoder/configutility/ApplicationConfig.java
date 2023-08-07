package com.unitedcoder.configutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationConfig {
    //write a method to read specific key value pair in properties file
    public static String readConfigProperties(String fileName, String key){
        Properties properties= new Properties();
        String value;
        try {
            properties.load(new FileInputStream(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        value=properties.getProperty(key);
        System.out.printf("%s=%s%n",key,value);
        return value;
    }
}
