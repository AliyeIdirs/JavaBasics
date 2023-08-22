package com.unitedcoder.io;

import java.io.File;

public class DirectoryDemo {
    public static void main(String[] args) {
        createADirectory("testDirectory");
    }
    public static void createADirectory( String directoryName){
        String workingDirectory=System.getProperty("user.dir");
        String dir=workingDirectory+File.separator+directoryName;

        File file=new File(dir);
        if(!file.exists()){
            boolean isFolderCreated=file.mkdir();
            System.out.println("Directory "+directoryName+" is created. "+isFolderCreated);
        }else{
            System.out.println("Directory "+directoryName+" is already existed!");
        }
    }
}
