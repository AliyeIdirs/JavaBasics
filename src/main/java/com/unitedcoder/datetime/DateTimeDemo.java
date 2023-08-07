package com.unitedcoder.datetime;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeDemo {
    public static void main(String[] args) {

        System.out.println("Current time by nanoseconds "+System.currentTimeMillis());

        //Java Date Utility
        Date date=new Date();
        String pattern="yyyy-MM-dd-hh-mm-ss";
        SimpleDateFormat format=new SimpleDateFormat(pattern);
        System.out.println(format.format(date));
        System.out.println(" ");

        //from Joda to JDK
        DateTime dt=new DateTime(); //joda.time
        Date jdkDate=dt.toDate(); //java.util

        //from JDK to Joda
        dt= new DateTime(jdkDate);
        System.out.println("Current date time is "+ dt);

        //get day, month, year
        System.out.println("Day: "+dt.getDayOfMonth()+" Year: "+dt.getYearOfEra()+ " Month: "+dt.getMonthOfYear());

        //add 1 month, add 10 days
        System.out.println(" ");
        System.out.println("Current date time is: "+ dt);
        System.out.println("Add 1 month: "+dt.plusMonths(1));
        System.out.println("Add 10 days: "+dt.plusDays(10));

        //get date time differences
        DateTime d1= new DateTime("2017-10-05");
        DateTime d2= new DateTime("2023-05-28");
        Duration duration=new Duration(d1,d2);

        System.out.println("Difference is: "+duration.getStandardDays()+" days.");

    }
}
