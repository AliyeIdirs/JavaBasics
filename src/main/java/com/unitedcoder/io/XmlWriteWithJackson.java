package com.unitedcoder.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.unitedcoder.objects.Student;
import com.unitedcoder.objects.StudentInfo;

import java.io.File;
import java.io.IOException;

public class XmlWriteWithJackson {
    public static void main(String[] args) throws IOException {
        String workinfDir= System.getProperty("user.dir");
        String filePath=workinfDir+ File.separator;
        //define Jackson xml module
        JacksonXmlModule module=new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        XmlMapper xmlMapper=new XmlMapper(module);
        Student[] students=new Student[] {
                new Student(1,"FisrtNameA","LastNameA","Math","Science"),
                new Student(2,"FirstNameB","LastNameB","Programming","Science"),
                new Student(3,"FirstNameC","LastNameC","English","Liberal Art")
        };
        StudentInfo studentInfo=new StudentInfo(students);
        try{
            String xml=xmlMapper.writeValueAsString(studentInfo);
            xmlMapper.writeValue(new File(filePath+"docs/StudentIndo.xml"),studentInfo);
            System.out.println(xml);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
    }
}
