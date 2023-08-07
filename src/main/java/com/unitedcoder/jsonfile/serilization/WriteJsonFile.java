package com.unitedcoder.jsonfile.serilization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unitedcoder.jsonfile.deserilization.cubecartautomation.CubeCartMainJson;
import com.unitedcoder.jsonfile.deserilization.cubecartautomation.Customer;
import com.unitedcoder.jsonfile.deserilization.cubecartautomation.LoginUser;
import com.unitedcoder.jsonfile.deserilization.cubecartautomation.Product;

import java.io.File;
import java.io.IOException;


public class WriteJsonFile {
    public static void main(String[] args) {

        String url="http://cubecartuat.unitedcoder.com/admin_tu8sml.php";
        LoginUser loginUser=new LoginUser("testautomation1","automation123!");
        Customer customer=new Customer("Michle","Scofiold","michles@outlook.com");
        Product product=new Product("Macbook Air M2","M2023","manufacturer1","Electronic Device");
        CubeCartMainJson mainJson=new CubeCartMainJson(loginUser,customer,product,url);

        ObjectMapper mapper=new ObjectMapper();
        try {
            mapper.writeValue(new File("jsonfile/testWriter.json"),mainJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
