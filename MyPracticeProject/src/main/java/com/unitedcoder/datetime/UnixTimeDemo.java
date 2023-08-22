package com.unitedcoder.datetime;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UnixTimeDemo {
    public static void main(String[] args) {

        //define simple date time format
        DateFormat dateFormat= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //define Joda date time
        DateTime dt= new DateTime();
        //get current date time
        Date currentDateTime= dt.toDate();
        System.out.println(currentDateTime);
        System.out.println(dateFormat.format(currentDateTime));

        //convert current date time to unix format
        try{
            long currentDateTimeEpoch=dateFormat.parse(dateFormat.format(currentDateTime)).getTime();

            //print out unix format of current date time
            System.out.println("Current Date Time in Unix Format: "+currentDateTimeEpoch);
        } catch(ParseException e){
            e.printStackTrace();
        }

        //initialize days to add
        int daysToAdd=30;
        Date newDate=dt.plusDays(daysToAdd).toDate();
        System.out.println("New Date after adding days "+newDate);
        //convert new date to unix string
        try{
            long unixTimeEpoch= dateFormat.parse(dateFormat.format(newDate)).getTime();
            System.out.println("New Date Time in Unix Format: "+unixTimeEpoch);
        } catch(ParseException e){
            e.printStackTrace();
        }
    }
}
