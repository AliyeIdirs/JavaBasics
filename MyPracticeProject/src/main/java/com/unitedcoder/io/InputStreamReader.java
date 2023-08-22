package com.unitedcoder.io;

import java.io.*;

public class InputStreamReader {

    public static void main(String[] args) {
        try {
            System.out.println(readToString("testDirectory"+File.separator+"test1.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String readToString(String fileToText) throws IOException {
        StringBuilder contents= new StringBuilder();
        String workingDir=System.getProperty("user.dir");
        File filePath=new File(workingDir+File.separator);
        System.out.println(filePath);

       Reader reader=null;
        try{
             InputStream inputStream=new FileInputStream(filePath+File.separator+fileToText);
           reader=new java.io.InputStreamReader(inputStream);

            int data = reader.read();
            while(data !=-1){
                char theChar=(char) data;
                data=reader.read();
                contents.append(theChar);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            reader.close();
        }
        return contents.toString();
    }
}
