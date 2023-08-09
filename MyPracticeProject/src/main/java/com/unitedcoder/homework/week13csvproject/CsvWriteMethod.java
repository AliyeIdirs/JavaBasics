package com.unitedcoder.homework.week13csvproject;

import java.io.*;

public class CsvWriteMethod {
    public static StringBuilder csvRecords=new StringBuilder();

    //write method
     public static void writeTargetFile(String fileContent, String fileName) {
        //define the destination file
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + File.separator + fileName;
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File " + fileName + " is created.");
            } else {
                String newFilePath = file.getParent() + File.separator + "backup_" + file.getName();
                File backupFile = new File(newFilePath);
                file.renameTo(backupFile);
                file.createNewFile();
                System.out.println("File already exist and backup file is created.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Writer writer = new OutputStreamWriter(outputStream);
        try {
            writer.write(fileContent);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

       public static String writeCsvHeader(String[] headers) {
           StringBuilder csvHeader = new StringBuilder();
           int totalHeaders = headers.length;
           for (int i = 0; i < totalHeaders; i++) {
               //if not last header, append comma after each header
               if (i != totalHeaders - 1) {
                   csvHeader.append(headers[i]).append(",");
               } else {
                   //if last header, just append the header
                   csvHeader.append(headers[i]);
               }
           }
           csvRecords.append("\n");
           return csvHeader.toString();
       }
       public static void writeCsvRecords(String[] records) {
           int numberOfColumns = records.length;
           for (int i = 0; i < numberOfColumns; i++) {
               //if not the last column, append comma after each column
               if (i != numberOfColumns - 1) {
                   csvRecords.append(records[i]);
                   csvRecords.append(",");
               } else {
                   //if last column, just append the column
                   csvRecords.append(records[i]);
               }
           }
           csvRecords.append("\n");
       }

}
