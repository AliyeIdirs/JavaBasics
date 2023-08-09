package com.unitedcoder.homework.week13csvproject;

public class CsvReadTest {
    public static void main(String[] args) {
        CsvReadMethod csvReadMethod=new CsvReadMethod();
        csvReadMethod.readCsvFile("docs/homework.csv");
    }
}
