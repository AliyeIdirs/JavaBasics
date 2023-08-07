package com.unitedcoder.homework.week15jsondatastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class WriteProductJsonFile {
    public static void main(String[] args) {
        ObjectMapper mapper=new ObjectMapper();
        Product product=new Product(true,"iphone 12x","apple","iphone12x",10.50,5.0,8.0,100,10,true);
        String s="";
        try {
            s=mapper.writeValueAsString(product);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            FileUtils.writeStringToFile(new File("jsonfile/product.json"),s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(s);
    }
}
