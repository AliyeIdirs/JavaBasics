package com.unitedcoder.commandline;

import org.apache.commons.cli.*;
import org.apache.commons.lang3.time.StopWatch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PassingArgumentWithKeyValue {
    public static void main(String[] args) {
        // Create command line option object
        Options options = new Options();

        // Create option
        Option testInterval = new Option("i", "interval", true, "time interval to check the status");
        testInterval.setRequired(true);
        options.addOption(testInterval);

        Option testEnvironment = new Option("e", "environment", true, "test environment url");
        testEnvironment.setRequired(true);
        options.addOption(testEnvironment);

        //Create command line parser
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine terminal;

        try {
            terminal = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("command - options", options);
            System.exit(1);
            return;
        }
        String time= terminal.getOptionValue("interval");
        String url=terminal.getOptionValue("environment");
        System.out.println("time interval is: "+time+" seconds");
        System.out.println("environment is: "+url);
        StopWatch stopWatch= new StopWatch();
        stopWatch.start();
        long elapsedSeconds=0;
        for(int i=0; ; i++){

            //get time returns milliseconds
            DateFormat dateFormat= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date= new Date();
            String currentTime=(dateFormat.format(date));
            System.out.printf("Loop %d Time %s%n",i,currentTime);
            stopWatch.suspend();
            elapsedSeconds=stopWatch.getTime()/1000;
            System.out.printf("Loop %d Time is %s, Elapsed Seconds %d%n",i,currentTime,elapsedSeconds);
            if(elapsedSeconds>=Integer.parseInt(time))
            break;
            stopWatch.resume();
        }
    }
}
