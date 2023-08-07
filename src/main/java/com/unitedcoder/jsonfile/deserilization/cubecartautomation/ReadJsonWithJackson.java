package com.unitedcoder.jsonfile.deserilization.cubecartautomation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unitedcoder.jsonfile.serilization.testreport.MainJson;
import com.unitedcoder.jsonfile.serilization.testreport.TestSteps;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadJsonWithJackson {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println("Reading JSON from a file");
            System.out.println("----------------------------");
            //convert the json string back to object
            MainJson mainJson = objectMapper.readValue(new File("jsonfile/test.json"), MainJson.class);
            System.out.println("Name Of Test Name: " + mainJson.getTestName());
            System.out.println("Name of Test Module: " + mainJson.getTestModule());
            System.out.println("Name of Test Type: " + mainJson.getTestType());
            System.out.println("Name of Test Verification: " + mainJson.getVerification());
            System.out.println("Test Steps are :");
            List<TestSteps> testSteps = mainJson.getTestSteps();
            for (int i = 0; i < testSteps.size(); i++) {
                System.out.println("Id: " + testSteps.get(i).getId() + "   Step:  " + testSteps.get(i).getStep());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
