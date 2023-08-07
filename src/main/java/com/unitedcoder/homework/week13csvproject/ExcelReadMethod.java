package com.unitedcoder.homework.week13csvproject;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReadMethod {
    public static void main(String[] args) {
        ExcelReadMethod excelReadMethod=new ExcelReadMethod();
        String fileName="testdatafolders/TestDataFile.xlsx";
        excelReadMethod.readExcelCellContent(fileName,"TestResult",5,5);

    }

    public String readExcelCellContent(String fileName, String sheetName, int rowNumber,int cellNumber){
        String filePath=System.getProperty("user.dir")+ File.separator+fileName;
        String cellValue="";
        try{
        FileInputStream inputStream=new FileInputStream(filePath);
        XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
        XSSFSheet sheet=workbook.getSheet(sheetName);
        XSSFRow row=sheet.getRow(rowNumber);

        if(row==null){
            System.out.println("Empty row!!!");
        }else {
            XSSFCell cell = row.getCell(cellNumber);
            if (cell == null) {
                System.out.println("Empty cell!!!");
            } else {
                CellType cellType = cell.getCellType();
                switch (cellType) {
                    case NUMERIC:
                        cellValue = String.valueOf(cell.getNumericCellValue());
                        break;
                    case STRING:
                        cellValue = cell.getStringCellValue();
                        break;
                    case BOOLEAN:
                        cellValue = Boolean.toString(cell.getBooleanCellValue());
                        break;
                    case BLANK:
                        cellValue = "Blank cell";
                        break;
                    case _NONE:
                        cellValue = "None";
                        break;
                    case ERROR:
                        cellValue = String.valueOf(cell.getErrorCellValue());
                        break;
                }
            }
        }
        }catch (IOException e){
            e.getMessage();
        }
        System.out.println(cellValue);
    return cellValue;
    }
}
