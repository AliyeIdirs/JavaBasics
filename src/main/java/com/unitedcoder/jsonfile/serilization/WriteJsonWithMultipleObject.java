package com.unitedcoder.jsonfile.serilization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unitedcoder.cubecartautomation.LoginUser;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteJsonWithMultipleObject {
    public static void main(String[] args) {
        LoginUser loginUser = new LoginUser("test", "automation",
                "abs2@gmail.com", "Admin user");
        LoginUser loginUser1 = new LoginUser("test2", "automation",
                "abs2@gmail.com", "Customer");
        LoginUser loginUser2 = new LoginUser("test3", "automation",
                "abs2@gmail.com", "Employee");

        List<LoginUser> users = new ArrayList<>();
        users.addAll(Arrays.asList(loginUser,loginUser1,loginUser2));
        ObjectMapper mapper=new ObjectMapper();
        String objectValue=null;
        try {
            objectValue=mapper.writeValueAsString(users);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            FileUtils.writeStringToFile(new File("jsonfile/users-info.json"),objectValue);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
