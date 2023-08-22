package com.unitedcoder.datetime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.time.ZoneId;
import java.util.Set;

public class JodaTimeDemo {
    public static void main(String[] args) {
        DateTime time= new DateTime();
        System.out.println(time);

        DateTimeFormatter formatter= DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss:SS");
        System.out.println(time.toString(formatter));

        DateTime universalTime= new DateTime(DateTimeZone.UTC);
        System.out.println(universalTime);

        DateTime istanbulTime= new DateTime(DateTimeZone.forID("Europe/Istanbul"));
        System.out.println(istanbulTime);

        Set<String> timeZones= ZoneId.getAvailableZoneIds();
 /*       for(String z:timeZones){
            System.out.println(z);
        }*/

        DateTime macaoTime =new DateTime(DateTimeZone.forID("Asia/Macao"));
        System.out.println(macaoTime);

        DateTime kashgarTime= new DateTime(DateTimeZone.forID("Asia/Kashgar"));
        System.out.println(kashgarTime);

        System.out.println(universalTime.getDayOfMonth());
        System.out.println(universalTime.getDayOfYear());

        DateTime.Property dayName= universalTime.dayOfWeek();
        System.out.println(dayName.getAsShortText());
        System.out.println(dayName.getAsText());

        //get differences
        DateTime beginDateTime= new DateTime("2023-05-15");
        DateTime executionDate= new DateTime();
        Period period1= new Period(beginDateTime,executionDate, PeriodType.days());
        System.out.println(period1.getDays());
    }
}
