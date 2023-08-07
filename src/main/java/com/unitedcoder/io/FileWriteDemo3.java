package com.unitedcoder.io;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileWriteDemo3 {

    public static void main(String[] args) {
        String textContent="Content created on PC: "+getCurrentTestHostName();
        textContent=textContent+"\n"+"Content created by: "+getCurrentTestUserName();
        textContent=textContent+"\n"+"Hello Test";
        textContent=textContent+"\n"+"This is file creation example";
        writeToFile(textContent,"testDirectory","test1",".txt");
        //FileUtils.deleteQuietly(new File("testDirectorytest22023-07-06 14:55:17:059.txt"));

    }

    public static void writeToFile(String fileContent,String folderName,String fileName, String fileExtension ){
        String projectPath= System.getProperty("user.dir");
        String separator=File.separator;
        String filePath=projectPath+separator+folderName+separator+fileName+fileExtension;
        File file=new File(filePath);
        try {
            if (!file.exists()) {
                boolean isCreateSuccessful=file.createNewFile();
                System.out.println("File " + file.getName()+" is created. "+isCreateSuccessful);
            } else {
                System.out.println(fileName +" is already exist.");
                String absolutePath=file.getAbsolutePath();
                String folderPath=absolutePath.substring(0,absolutePath.lastIndexOf(separator));
                File newFileName = new File(folderPath + separator + "backup_"+getCurrentTimeStamp() + file.getName());
                System.out.println("BackUp file "+newFileName.getName()+" is created");
                file.renameTo(newFileName);
                System.out.println("File "+fileName+" is renamed to "+newFileName.getName());

            }
        }catch (IOException e) {
                throw new RuntimeException(e);
            }

        //write to file with OutputStreamWriter
        OutputStream outputStream= null;
        try {
            outputStream = new FileOutputStream(file.getAbsoluteFile());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Writer writer= new OutputStreamWriter(outputStream);
        try {
            writer.write(fileContent);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Get Current System Time
    public static String getCurrentTimeStamp(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy.MM.dd HH_mm_ss_SSS");
        Date now= new Date();
        String strDate=format.format(now);
        strDate= strDate.replace(".","-").replace("_",":");
        return strDate;
    }

    //Get Current Host Name
    public static String getCurrentTestHostName(){
        InetAddress localMachine=null;
        try {
           localMachine= InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String hostName= localMachine.getHostName();
        return hostName;
    }

    //Get Current User Name
    public static String getCurrentTestUserName(){
        return System.getProperty("user.name");
    }
}
