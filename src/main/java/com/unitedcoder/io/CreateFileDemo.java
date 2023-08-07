package com.unitedcoder.io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateFileDemo {


    public static void main(String[] args) {
        createAFile("docs", "Selenium", ".txt");

    }

    //Create a new file with time stamp
    public static void createAFile(String folderName, String fileName, String fileExtension) {
        //get current project path
        String filePath = System.getProperty("user.dir");
        String folderLocation=filePath+File.separator+folderName;
        File folder=new File(folderLocation);
        if(!folder.exists()){
            folder.mkdir();
            System.out.println("Folder "+folderName+" is created.");
        }
        //get current date time stamp
        Date currentDate = new Date();
        String pattern = "yyyy-MM-dd-hh:mm:sss";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String timeStamp = format.format(currentDate).replace("-", "_");
        //create a new file object instance
        String fileLocation=folderLocation+File.separator+fileName+timeStamp+fileExtension;
        File file= new File(fileLocation);
        if(!file.exists()){
            try {
                file.createNewFile();
                System.out.println("File "+fileName+timeStamp+fileExtension +" is created.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
