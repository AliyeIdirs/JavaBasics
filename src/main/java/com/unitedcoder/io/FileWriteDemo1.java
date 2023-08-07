package com.unitedcoder.io;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class FileWriteDemo1 {
    public static void main(String[] args) {
        String s1="I am a United Coder Student";
        String s2="I am learning Java SDET to find a job";
        String finalContent=s1+"\n"+s2;
        FileUtility fileUtility= new FileUtility();
        fileUtility.writeToFile("doc","test-automation"+getCurrentDateTime(),
                ".txt",finalContent);
    }

    public static String getCurrentDateTime(){
        DateTime dateTime= new DateTime();
        DateTimeFormatter formatter= DateTimeFormat.forPattern("yyyy-MM-dd-HH:mm:ss:SSS");
        return dateTime.toString(formatter);
    }
}
