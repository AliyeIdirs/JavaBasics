package com.unitedcoder.homework.week13csvproject;

public class CsvWriteTest extends CsvWriteMethod{

    public static void main(String[] args) {
        String header=writeCsvHeader(new String[]{"Username","Userpassword","UserType"});

        String[] s1={"admin","test1","admin"};
        String[] s2={"student","test2","student"};
        String[] s3={"staff","test3","staff"};

        String fileName="docs/homework.csv";

        writeCsvRecords(s1);
        writeCsvRecords(s2);
        writeCsvRecords(s3);

        writeTargetFile(header+csvRecords.toString(),fileName);
    }
}
