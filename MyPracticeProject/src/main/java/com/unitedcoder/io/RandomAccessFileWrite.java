package com.unitedcoder.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileWrite {
    public static void main(String[] args) {
        writeToFile("testDirectory/test1.txt");
    }
    public static void writeToFile(String fileToText){
        String workingDir=System.getProperty("user.dir");
        String filePath=workingDir+ File.separator;

        try{
            RandomAccessFile file=new RandomAccessFile(filePath+File.separator+fileToText,"rw"); //rw represents writing mode
            System.out.println(file.readLine());
            long pointer=file.getFilePointer();
            System.out.println(pointer);

            //move cursor to the line of the file
            file.seek(file.length());
            file.write("This is second example of random access file\n".getBytes());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
