package com.unitedcoder.excelfile;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelWriteDemo {
    public static void main(String[] args) {
        List<String> excelContent=new ArrayList<>();

        excelContent.add("TestId,TestName,TestModule,TestType,TestSteps,Action,TestResult,Note");
        excelContent.add("1,Login,Dashboard,Regression,1,OpenBrowser,Browser should open,This is a note");
        excelContent.add("2,Add new client,Dashboard,Regression,1,Add new client,New client is added,Note for client");
        excelContent.add("3,Logout,Dashboard,Regression,1,Click Logout link,Logged out from system,Note for logout");

        writeToExcel("testdatafolders/workbook1.xlsx","TestCases",excelContent);
    }

    public static void writeToExcel(String fileName, String sheetName, List<String> content){
        XSSFWorkbook workbook=new XSSFWorkbook();
        FileOutputStream outputStream;
        try {
           outputStream=new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet=workbook.createSheet(sheetName);
        int numberOfRows=content.size();
        for(int r=0; r<numberOfRows;r++){
            XSSFRow row=sheet.createRow(r);
            String[] rowContent=content.get(r).split(",");
            int totalCells=rowContent.length;
            for(int c=0;c<totalCells;c++){
                XSSFCell cell=row.createCell(c);
                cell.setCellValue(rowContent[c]);
            }

        }
        try {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
