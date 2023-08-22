package com.unitedcoder.excelfile;

import com.unitedcoder.cubecartautomation.UiUtility;
import com.unitedcoder.io.FileUtility;
import com.unitedcoder.io.FileWriteDemo1;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExcelWriteDemoTest {
    public static void main(String[] args) {
        ExcelUtility excelUtility=new ExcelUtility();
        String fileName="testdatafolders/testReport.xlsx";

        List<String> content= new ArrayList<>();

        content.add("test-name,test-module,test-status,executedAt,executedBy");
        content.add("login-test,Login-module,passed,"+ UiUtility.getCurrentDateTime()+","+UiUtility.getCurrentUserName());
        content.add("add-customer,customer-module,passed,"+ UiUtility.getCurrentDateTime()+","+UiUtility.getCurrentUserName());
        content.add("add-product,Inventory-module,passed,"+ UiUtility.getCurrentDateTime()+","+UiUtility.getCurrentUserName());

        excelUtility.writeToExcelCells(fileName,"Test-Report",content);
    }

}
