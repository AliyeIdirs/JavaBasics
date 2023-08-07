package com.unitedcoder.homework.week13csvproject;

import com.csvreader.CsvReader;

import java.io.IOException;

public class CsvReadMethod {

    public void readCsvFile(String fileName){
        try {
            CsvReader csvReader = new CsvReader(fileName);
            csvReader.readHeaders();
            //get total number of header column
            int headerColumnCount = csvReader.getHeaderCount();
            //print out header column
            for (int i = 0; i < headerColumnCount; i++) {
                System.out.print(csvReader.getHeader(i) + ",");
            }
            System.out.println();
            while (csvReader.readRecord()) {
                String userName = csvReader.get("Username");
                String password = csvReader.get("Userpassword");
                String userType = csvReader.get("UserType");

                System.out.println(userName + "," + password + "," + userType);
            }
            csvReader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
