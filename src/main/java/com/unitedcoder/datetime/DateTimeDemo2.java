package com.unitedcoder.datetime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

public class DateTimeDemo2 {
    public static void main(String[] args) {
        //define joda date time
        DateTime dt= new DateTime();

        //get current date time from Joda to JDK
        Date currentDateTime=dt.toDate();

        //print out current date time in simple date time format
        System.out.println(currentDateTime);

        //convert JDK date to Joda time
        dt= new DateTime(currentDateTime);

        //get current day
        int dow= dt.dayOfMonth().get();
        System.out.println(dow+ " day");

        //add few days
        int daysToAdd=5;
        int newDay=dt.plusDays(daysToAdd).getDayOfMonth();
        System.out.println(newDay+ " day");

        //get day time property
        dt = new DateTime(dt.plusDays(daysToAdd));
        DateTime.Property pDoW=dt.dayOfWeek();
        String shortDayName=pDoW.getAsShortText();
        System.out.println("Short day name "+shortDayName);
        String fullDayName=pDoW.getAsText();
        System.out.println("Full day name "+fullDayName);

        // get month info
        String month = dt.monthOfYear().getAsText();
        System.out.println("Month is "+month);
        int maxDay=dt.dayOfMonth().getMaximumValue();
        System.out.println("Maximum days "+maxDay);
        boolean leapYear= dt.yearOfEra().isLeap();
        System.out.println("Is leap year: "+leapYear);

        //get era, century, month, week, day information
        System.out.println("Era is: "+dt.getEra()); //1
        System.out.println("Century is: "+dt.getCenturyOfEra()); //20
        System.out.println("Year is: "+dt.getYear()); //2023
        System.out.println("Week is: "+dt.getWeekOfWeekyear()); //22
        System.out.println("Year of era is: "+dt.getYearOfEra()); //2023
        System.out.println("Year of century is: "+dt.getYearOfCentury()); //23
        System.out.println("Month of year: "+dt.getMonthOfYear()); //6
        System.out.println("Day of year is: "+dt.getDayOfYear());//153
        System.out.println("Day of month is "+dt.getDayOfMonth()); //2
        System.out.println("Day of week is: "+dt.getDayOfWeek()); //5

        //format date time
        DateTimeFormatter fmt= DateTimeFormat.forPattern("yyyy/MM/dd");
        String d= dt.toString(fmt);
        System.out.println("Time in format yyyy/MM/dd is "+d);

        //Date time zone
        DateTime dt1=new DateTime();
        Date current=dt1.toDate();
        dt1= new DateTime(current);

        DateTimeZone zoneLondon= DateTimeZone.forID("Europe/London");
        DateTime dtZoneLondon=new DateTime(dt1.withZone(zoneLondon));
        System.out.println("Date time in London zone "+dtZoneLondon);

        DateTimeZone zoneHongKong= DateTimeZone.forID("Asia/Hong_Kong");
        DateTime dtZoneHongKong= new DateTime(dt1.withZone(zoneHongKong));
        System.out.println("Date time in HongKong zone "+dtZoneHongKong);
    }
}
