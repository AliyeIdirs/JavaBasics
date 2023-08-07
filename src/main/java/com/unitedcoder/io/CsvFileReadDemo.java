package com.unitedcoder.io;

import com.csvreader.CsvReader;

import java.io.IOException;

public class CsvFileReadDemo {
    public static void main(String[] args) {
        try{
            CsvReader testUsers=new CsvReader("docs/testuser.csv");
            testUsers.readHeaders();
            //get total number of header column
            int numberOfHeaders=testUsers.getHeaderCount();
            System.out.println("Number of columns in the header is: "+numberOfHeaders);
            //print header column
            for(int i=0; i<numberOfHeaders;i++){
                System.out.print(testUsers.getHeader(i)+", ");
            }
            System.out.println();
            while(testUsers.readRecord()){
                String testUser=testUsers.get("TestUser");
                String password=testUsers.get("Password");
                String role=testUsers.get("Role");
                //output file content
                System.out.println(testUser+", "+password+", "+role);
            }
            testUsers.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
