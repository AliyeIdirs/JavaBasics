package com.unitedcoder.io;

import java.io.File;

public class ListFilesDemo {
    public static void main(String[] args) {
        listFiles("docs");
    }
    public static void listFiles(String directoryName){
        String workingDirectory=System.getProperty("user.dir");
        System.out.println("Current project directory "+workingDirectory);
        String dir=workingDirectory+ File.separator+directoryName;
        System.out.println("Final file directory is: "+dir);

        //list files in the directory
        File file= new File(dir);
        File[] files=file.listFiles();
        if(file.exists()){
            System.out.println("Directory is found!");
            for(File eachFile:files){
                System.out.println(eachFile.getName());
            }
        }else{
            System.out.println("Directory is not exist.");
        }

    }
}
