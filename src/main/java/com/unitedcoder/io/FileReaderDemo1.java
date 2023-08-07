package com.unitedcoder.io;

import java.io.*;

public class FileReaderDemo1 {
    public static void main(String[] args) {
        readToString("testDirectory"+File.separator+"test1.txt");
    }

    public static String readToString(String fileToText){
        String workingDirectory=System.getProperty("user.dir");
        StringBuilder fileContent=new StringBuilder();
        File file=new File(workingDirectory+File.separator);
        System.out.println(file);

        FileReader fr= null;
        try {
            fr = new FileReader(file+ File.separator+fileToText);
            BufferedReader br= new BufferedReader(fr);
            String sCurrentLine;
            while((sCurrentLine=br.readLine())!=null){
                fileContent.append(sCurrentLine).append("\n");

            }
        } catch (IOException e) {
            System.out.println("cannot read the text file");
        }
        System.out.println(fileContent.toString());
        return fileContent.toString();

    }
}
