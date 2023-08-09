package com.unitedcoder.homework.week13csvproject;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelWriteMethod {
    public static void main(String[] args) {
        ExcelWriteMethod excelWriteMethod=new ExcelWriteMethod();
        String fileName="testdatafolders/writingtest.xlsx";
        List<String> cellValues= new ArrayList<>();
        cellValues.add("TestId,TestName,Status");
        cellValues.add("1,Login,pass");
        cellValues.add("2,Add Customer,pass");
        cellValues.add("3,Delete Customer, failed");
        excelWriteMethod.writeExcelCellContent(fileName,"Test Result",cellValues);
    }

    public void writeExcelCellContent(String fileName, String sheetName, List<String> cellValues){
        FileOutputStream outputStream= null;
        try {
            outputStream = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet(sheetName);
        for(int i=0; i<cellValues.size(); i++){
            XSSFRow row=sheet.createRow(i);
            String[] rowContent=cellValues.get(i).split(",");
            for(int j=0; j<rowContent.length; j++){
                XSSFCell cell=row.createCell(j);
                cell.setCellValue(rowContent[j]);
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
