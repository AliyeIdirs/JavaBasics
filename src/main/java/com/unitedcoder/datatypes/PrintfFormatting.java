package com.unitedcoder.datatypes;

import java.util.Date;
import java.util.Locale;

public class PrintfFormatting {
    public static void main(String[] args) {

        //Syntax
        //System.out.printf(format,arguments);
        //System.out.println(locale, format,arguments);

        //format rules
        //%[flags][width][.precision]conversion-character

        //String formatting %S / %s
        System.out.printf("Hello %s!%n","World");
        System.out.printf("'%S' %n","aliye"); //ALIYE
        System.out.printf("'%s' %n","aliye"); //aliye
        System.out.printf("'%15s' %n","homework"); //spaces before text, width is 15
        System.out.printf("'%-10s' %n","homework"); //spaces after text, width is 10
        System.out.printf("%2.2s %n","Hi there!"); //character count is n+1
        System.out.printf("%7.5s %n","Hi my name is aliye!"); //character count is 7+1=8


        //Line separator %n
        System.out.printf("United%nCoder%nLLc%n"); //%n line separator

        //Boolean formatting %B / %b
        System.out.printf("%b%n",null); //false
        System.out.printf("%B%n",false); //FALSE
        System.out.printf("%B%n",5.3); //TRUE
        System.out.printf("%b%n","random text"); //true

        //Char formatting %C / %c
        System.out.printf("%c%n",'s');
        System.out.printf("%C%n", 'S');

        //Number formatting
        System.out.printf("simple integer: %d%n",10000L);
        System.out.printf(Locale.US,"%d%n",10000); //10,000
        System.out.printf(Locale.ITALY,"%d%n",10000); //10.000

        //Float and Double formatting
        System.out.printf("%f%n",232423.4324);
        System.out.printf("'%5.2f'%n",5.1473); //width of the number is 5
        System.out.printf("'%5.2e'%n",5.1473); // Scientific notation

        //Date and Time formatting
        //Time formatting: %tT %tH %tM %tS %tp %tL %tN %tz 1$
        //H, M, S characters are responsible for extracting the hours, minutes and seconds from the input Date.
        //L, N represent the time in milliseconds and nanoseconds accordingly.
        //p adds a.m./p.m. formatting.
        //z prints out the time-zone offset.

        Date date=new Date();
        System.out.printf("%tT%n",date); //%tT is producing format hour:minute:second
        System.out.printf("hours %tH: minutes %tM: seconds %tS%n",date,date,date);
        System.out.printf("%1$tH:%1$tM:%1$tS %1$tp %1$tL %1$tN %1$tz %n",date); //1$ is the index reference of input parameter

        //Date formatting %1$tA %1$tB %1$tY
        //A prints out the full day of the week.
        //d formats a two-digit day
        //B is for the full month name.
        //m formats a two-digit month
        //Y outputs a year in four digits.
        //y outputs the last two digits of the year.
        System.out.printf("%1$tA %1$tB %1$tY %n",date); //String result
        System.out.printf("%1$td.%1$tm.%1$ty %n",date); //Numeric result




    }
}
