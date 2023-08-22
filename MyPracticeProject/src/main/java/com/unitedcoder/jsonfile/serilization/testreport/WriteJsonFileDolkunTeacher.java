package com.unitedcoder.jsonfile.serilization.testreport;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class WriteJsonFileDolkunTeacher {
    public static void main(String[] args) {
        createJson("jsonfile/dolkunteacher.json");

    }
    public static void createJson(String fileName){
        String projectPath=System.getProperty("user.dir");
        String filePath=projectPath+ File.separator+fileName;
        JsonObject jsonObject= Json.createObjectBuilder()
                .add("TestName","Login")
                .add("TestModule","Dashboard")
                .add("TestType","Regression")
                .add("TestSteps",Json.createArrayBuilder()
                        .add(Json.createObjectBuilder().add("Id",1).add("Step","Open browser"))
                        .add(Json.createObjectBuilder().add("Id",2).add("Step","Enter user name"))
                        .add(Json.createObjectBuilder().add("Id",3).add("Step","Enter user password"))
                        .add(Json.createObjectBuilder().add("Id",4).add("Step","Click on Login button")))
                .add("Verification","Logout link should display")
                .add("Verification","Logout link should display")
                .add("Note","Login test note.")
                .build();
        System.out.println(jsonObject.toString());
        JsonWriter writer= null;
        try {
            writer = Json.createWriter(new FileOutputStream(new File(filePath)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        writer.writeObject(jsonObject);
    }
}
