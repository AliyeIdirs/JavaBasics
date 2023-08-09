package com.unitedcoder.jsonfile.deserilization.cubecartautomation;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class CubeCartTestRunner extends FunctionLibrary{
    public static void main(String[] args) {
        ObjectMapper mapper=new ObjectMapper();
        CubeCartMainJson mainJson;
        try {
             mainJson= mapper.readValue(new File("jsonfile/cubecart-test-data.json"),CubeCartMainJson.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        openBrowser(mainJson.getUrl());
        login(mainJson.getLoginUsers());
        addCustomer(mainJson.getCustomers());
        addProduct(mainJson.getProducts());
        logOut();
        tearDown();
    }
}
