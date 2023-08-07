package com.unitedcoder.jsonfile.serilization.testreport;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SerilizationClass {
    public static void main(String[] args) {
        List<TestSteps> testSteps=new ArrayList<>();
        testSteps.add(new TestSteps(1,"Open browser"));
        testSteps.add(new TestSteps(2,"Enter user name"));
        testSteps.add(new TestSteps(3,"Enter user password"));
        testSteps.add(new TestSteps(4,"Click on Login button"));
        MainJson mainJson=new MainJson("","Logout link should display","Regression",
                "Dashboard",testSteps,"Login");
        ObjectMapper mapper=new ObjectMapper();
        try {
            mapper.writeValue(new File("jsonfile/WriteTestReport.json"),mainJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
