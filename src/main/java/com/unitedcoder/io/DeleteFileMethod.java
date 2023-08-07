package com.unitedcoder.io;

import java.io.File;

public class DeleteFileMethod {
    public static void main(String[] args) {
       deleteAFile("docs"+File.separator+".txt");
    }
    public static void deleteAFile(String fileName){
        String filePath=System.getProperty("user.dir");
        File file=new File(filePath+File.separator+fileName);
        if(!file.exists()){
            System.out.println("File is not found");
        }else{
            file.delete();
            System.out.println("File "+fileName+" is deleted");
        }
    }
}
