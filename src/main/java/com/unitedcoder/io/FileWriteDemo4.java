package com.unitedcoder.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteDemo4 {
    public static void main(String[] args) {
        StringBuilder builder= new StringBuilder();
        builder.append("Hello Test\n");
        builder.append("Selenium Master\n");
        try {
            writeToFile(builder.toString(),"docs","test",".txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void writeToFile(String fileContent, String folderName,
                                   String fileName,String extension) throws IOException{
        String projectPath=System.getProperty("user.dir");
        String separator= File.separator;
        String filePath=projectPath+separator+folderName+separator+fileName+extension;
        File file= new File(filePath);
        if(file.exists()){
            try{
                File newFileName=new File(projectPath+separator+folderName+separator+"backup_"+fileName+extension);
                file.renameTo(newFileName);
                file.createNewFile();
            } catch(IOException e){
                e.printStackTrace();
            }
        }

        FileWriter wr= new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw=new BufferedWriter(wr);
            bw.write(fileContent);
        System.out.println(fileContent);
        bw.close();
    }
}
