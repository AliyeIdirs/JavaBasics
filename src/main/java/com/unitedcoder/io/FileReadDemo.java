package com.unitedcoder.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileReadDemo {
    public static void main(String[] args) {
        //file with content
        File fileToRead= new File("doc"+File.separator+"myFile.txt");
        StringBuilder builder= new StringBuilder();
        String fileContent="";
        try {
            fileContent= builder.append(FileUtils.readFileToString(fileToRead)).toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(fileContent);
    }
}
