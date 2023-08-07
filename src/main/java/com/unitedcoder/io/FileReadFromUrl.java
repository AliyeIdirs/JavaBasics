package com.unitedcoder.io;

import com.google.common.io.FileBackedOutputStream;

import java.io.*;
import java.io.InputStreamReader;
import java.net.URL;

public class FileReadFromUrl {
    public static void main(String[] args) {
        String projectPath=System.getProperty("user.dir");
        String filePath=projectPath+ File.separator;
        InputStream in=null;
        try{
            URL testUrl=new URL("https://commons.apache.org");
            in=testUrl.openStream();
        }catch (IOException e){
            e.printStackTrace();
        }

        BufferedReader reader= new BufferedReader(new InputStreamReader(in));
        StringBuilder result= new StringBuilder();
        String line;
        try{
            while((line=reader.readLine()) !=null){
                result.append(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(result);

        //Use Output Stream to create a file
        OutputStream outputStream=null;
        try {
             outputStream=new FileOutputStream(filePath+"testDirectory/temp1"+".html");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //Write output stream to a file
        Writer writer= new OutputStreamWriter(outputStream);
        try {
            writer.write(result.toString());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
