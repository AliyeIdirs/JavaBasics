package com.unitedcoder.io;

import java.io.*;

public class LineNumberReader {
    public static void main(String[] args) throws FileNotFoundException {
        readToString("testDirectory/test1.txt");
    }

    public static void readToString(String fileToRead) throws FileNotFoundException {
        String workingDir=System.getProperty("user.dir");
        File file =new File(workingDir+ File.separator+fileToRead);
        java.io.LineNumberReader reader= new java.io.LineNumberReader(new FileReader(file));
        BufferedReader br= new BufferedReader(new FileReader(file));
        System.out.println("Line Number:            Content:");
        try{
            while(reader.readLine()!= null){
                int lineNumber= reader.getLineNumber();
                String s= br.readLine();
                System.out.println(lineNumber +"                       "+s);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
