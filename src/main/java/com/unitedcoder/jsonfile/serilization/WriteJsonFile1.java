package com.unitedcoder.jsonfile.serilization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unitedcoder.cubecartautomation.LoginUser;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class WriteJsonFile1 {
    public static void main(String[] args) {
        LoginUser loginUser=new LoginUser("test","automation",
                "abs2@gmail.com","Admin user");
        ObjectMapper mapper=new ObjectMapper();
        String user= null;
        try {
            user = mapper.writeValueAsString(loginUser);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            FileUtils.writeStringToFile(new File("jsonfile/user-Info.json"),user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
