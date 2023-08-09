package com.unitedcoder.configutility;

import com.unitedcoder.cubecartautomation.BaseClass;
import com.unitedcoder.homework.week11cubecartproject.AdminUser;

public class CubeCartTestWithConfigFile extends BaseClass {
    public static void main(String[] args) {
        String fileName="config.properties";
        String url="";
        String userName=ApplicationConfig.readConfigProperties(fileName,"username");
        String password=ApplicationConfig.readConfigProperties(fileName,"password");
        if(Integer.parseInt(ApplicationConfig.readConfigProperties(fileName,"qa"))==1){
            url=ApplicationConfig.readConfigProperties(fileName,"qaurl");
        }else {
            url=ApplicationConfig.readConfigProperties(fileName,"produrl");
        }
        openBrowser(url);
        logIn(new AdminUser(userName,password));
        logOut();
        tearDown();

    }
}
