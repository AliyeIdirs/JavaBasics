package com.unitedcoder.excelfile;

import com.unitedcoder.cubecartautomation.LoginUser;

import java.io.IOException;
import java.util.List;

public class ReadFromExcelDemo1 {
    public static void main(String[] args) throws IOException {
        String fileName="testdatafolders/myFile.xlsx";
        ExcelUtility excelUtility= new ExcelUtility();
        String userName=excelUtility.readFromExcelCell(fileName,"LoginInfo",1,0);
        String password= excelUtility.readFromExcelCell(fileName,"LoginInfo",1,1);

        List<LoginUser> users=excelUtility.readFromMultipleCell(fileName,"LoginInfo");
        System.out.println(users);
    }
}
