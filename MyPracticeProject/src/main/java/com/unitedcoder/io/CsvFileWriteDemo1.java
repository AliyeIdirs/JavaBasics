package com.unitedcoder.io;

import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CsvFileWriteDemo1 {
    public static void main(String[] args) {
        //define output file name
        String csvOutputFile="docs/writetest.csv";
        //check if file exist
        boolean isFileExist=new File(csvOutputFile).exists();
        try {
            //create a file writer constructor to open a file in appending mode
            CsvWriter csvWriter = new CsvWriter(new FileWriter(csvOutputFile, true), ',');
            //write header column if the file is not already exist
            if (!isFileExist) {
                csvWriter.write("TestId");
                csvWriter.write("TestName");
                csvWriter.write("TestModule");
                csvWriter.write("TestType");
                csvWriter.write("TestSteps");
                csvWriter.write("Action");
                csvWriter.write("TestResult");
                csvWriter.write("Note");
                //end the record
                csvWriter.endRecord();
            }
            //write content
            Random r = new Random();
            int testCaseID = r.nextInt(10000);
            //add record to the file
            csvWriter.write(String.valueOf(testCaseID));
            csvWriter.write("Login");
            csvWriter.write("Dashboard");
            csvWriter.write("Smoke");
            csvWriter.write("1");
            csvWriter.write("Open Browser");
            csvWriter.write("Pass");
            csvWriter.write("Browser opened");
            //end the record
            csvWriter.endRecord();
            csvWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
