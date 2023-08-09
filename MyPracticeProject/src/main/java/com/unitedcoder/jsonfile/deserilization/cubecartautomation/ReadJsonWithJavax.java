package com.unitedcoder.jsonfile.deserilization.cubecartautomation;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;

public class ReadJsonWithJavax {
    public static void main(String[] args) {
        try {
            readJason("jsonfile/WriteTestReport.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readJason(String fileName) throws IOException {

        String workingDir = System.getProperty("user.dir"); //return current project folder
        String filePath = workingDir + File.separator; //define a file path for the Json file folder
        System.out.println(filePath);
        //define Input Stream for the Json file
        InputStream inputStream = null;
        //define Json Reader
        JsonReader jsonReader = null;
        //define Json Object
        JsonObject jsonObject = null;
        try {
            inputStream = new FileInputStream(filePath + fileName);
            jsonReader = Json.createReader(inputStream);
            jsonObject = jsonReader.readObject();
            System.out.println(jsonObject.toString());
            System.out.println("Test Name: " + jsonObject.get("TestName"));
            System.out.println("Test Module: " + jsonObject.get("TestModule"));
            JsonArray testSteps = jsonObject.getJsonArray("TestSteps");
            int numberOfSteps = testSteps.size();//return number of entries in the json array
            for (int i = 0; i < numberOfSteps; i++) {
                JsonObject eachStep = testSteps.getJsonObject(i);
                System.out.println("Id  " + eachStep.get("Id") + " Step:  " + eachStep.get("Step"));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            jsonReader.close();
        }
    }

}
