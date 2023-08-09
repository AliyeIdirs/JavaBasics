package com.unitedcoder.jsonfile.deserilization;

import com.google.gson.Gson;
import com.unitedcoder.jsonfile.serilization.testreport.MainJson;
import com.unitedcoder.jsonfile.serilization.testreport.TestSteps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadJsonWithGson {
    public static void main(String[] args) {
        Gson gson = new Gson();
        try {
            System.out.println("Reading JSON from a file");
            System.out.println("----------------------------");

            BufferedReader br = new BufferedReader(new FileReader("jsonfile/test.json"));
            //convert the json string back to object
            MainJson mainJson = gson.fromJson(br, MainJson.class);

            System.out.println("Test Name: " + mainJson.getTestName());
            System.out.println("Test Module: " + mainJson.getTestModule());
            System.out.println("Test Verification: " + mainJson.getVerification());
            System.out.println("Test Steps are :");

            List<TestSteps> listOfTestSteps = mainJson.getTestSteps();
            for (TestSteps listOfTestStep : listOfTestSteps) {
                System.out.println("Id: " + listOfTestStep.getId() + "   Step:  " + listOfTestStep.getStep());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
