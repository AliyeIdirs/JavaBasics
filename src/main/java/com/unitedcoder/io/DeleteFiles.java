package com.unitedcoder.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DeleteFiles {
    public static void main(String[] args) {
        boolean ifFileDeleted= FileUtils.deleteQuietly(new File("doc"+ File.separator+"2023-07-03-15-34-57-356TestReport.txt"));
        System.out.println("File deleted is "+ifFileDeleted);

            boolean isFolderDeleted= FileUtils.deleteQuietly(new File("doc"));
        System.out.println("Is folder deleted "+isFolderDeleted);
    }
}
