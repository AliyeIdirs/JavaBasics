package com.unitedcoder.io;

import java.io.*;

public class CsvFileWriteDemo2 {
    //using the StringBuilder to create Csv File
    public static StringBuilder csvRecords=new StringBuilder();

    public static void main(String[] args) {
        String header=writeCsvHeader(new String[]{"TestID","TestModule","TestType"});
        writeCsvRecords(new String[]{"1","Login","Regression"});
        writeCsvRecords(new String[]{"2","Logout","Regression"});
        writeCsvRecords(new String[]{"3","Change User Settings","Regression"});
        try {
            writeToFile(header+csvRecords.toString(),"docs/CsvStringBuilder.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToFile(String fileContent, String fileName) throws IOException {
        String projectPath= System.getProperty("user.dir");
        String filePath=projectPath+ File.separator+fileName;
        File file=new File(filePath);
        //if file is exist, then rename and create a new file
        if(file.exists()){
            try {
            File newFileName=new File(file.getParent()+File.separator+"backup_"+file.getName());
            file.renameTo(newFileName);
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        FileWriter fw=new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write(fileContent);
        System.out.println(fileContent);
        bw.close();
    }

    public static String writeCsvHeader(String[] headers){
        StringBuilder csvHeader=new StringBuilder();
        int totalHeaders=headers.length;
        for(int i=0; i<totalHeaders; i++){
            //if not last header, append comma after each header
            if(i!=totalHeaders-1){
                csvHeader.append(headers[i]);
                csvHeader.append(",");
            }
            else{
                //if last header, just append the header
                csvHeader.append(headers[i]);
            }
        }
        csvRecords.append("\n");
        return csvHeader.toString();
    }

    public static void writeCsvRecords(String[] records){
        int numberOfColumns=records.length;
        for(int i=0; i<numberOfColumns; i++){
            //if not the last column, append comma after each column
            if(i!=numberOfColumns-1){
                csvRecords.append(records[i]);
                csvRecords.append(",");
            }else{
                //if last column, just append the column
                csvRecords.append(records[i]);
            }
        }
        csvRecords.append("\n");
    }
}
