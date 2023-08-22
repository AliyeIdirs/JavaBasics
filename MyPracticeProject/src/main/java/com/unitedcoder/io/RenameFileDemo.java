package com.unitedcoder.io;

import java.io.File;
import java.io.IOException;

public class RenameFileDemo {
    public static void main(String[] args) {
        renameFileExisting("docs"+File.separator+"Aliye.txt");
    }
    public static void renameFileExisting(String fileName){
        String projectPath=System.getProperty("user.dir");
        File file= new File(projectPath+File.separator+fileName);
        try {
        if(!file.exists()){
                file.createNewFile();
            System.out.println("File is created.");
        }else{
            //String absolutePath=file.getAbsolutePath();//return absolute path(folder +filename
            //String filePath=absolutePath.substring(0,absolutePath.lastIndexOf(File.separator)); //directory path

            File backupFile=new File(file.getParent()+File.separator+"backup_"+file.getName());
            System.out.println("File already exist and backup file is created.");
            file.renameTo(backupFile);

        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
