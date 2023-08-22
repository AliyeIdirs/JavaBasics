package com.unitedcoder.excelfile;

import com.unitedcoder.configutility.ApplicationConfig;
import com.unitedcoder.cubecartautomation.BaseClass;
import com.unitedcoder.cubecartautomation.LoginUser;
import com.unitedcoder.homework.week11cubecartproject.AdminUser;

import java.io.IOException;
import java.util.List;

public class MultipleRoleTest extends BaseClass {
    public static void main(String[] args) throws IOException {
        openBrowser(ApplicationConfig.readConfigProperties("config.properties","qaurl"));
        String fileName="testdatafolders/myFile.xlsx";
        ExcelUtility excelUtility= new ExcelUtility();
        List<LoginUser> users=excelUtility.readFromMultipleCell(fileName,"LoginInfo");
        for(LoginUser user:users) {
            try {
                logIn(new AdminUser(user.getUserName(), user.getPassword()));
                logOut();
            } catch (Exception e) {
                e.getMessage();
            }
        }
        tearDown();
    }
}
