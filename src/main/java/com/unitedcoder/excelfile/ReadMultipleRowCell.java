package com.unitedcoder.excelfile;

import com.beust.ah.A;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadMultipleRowCell {
    public static void main(String[] args) throws IOException {
        String filePath="TestDataFolders/Week13TestData/ProductInfo.xlsx";
        FileInputStream inputStream= new FileInputStream(filePath);
        XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
        XSSFSheet sheet=workbook.getSheetAt(0);
        int rowCount=sheet.getLastRowNum();
        int cellCount= sheet.getRow(0).getLastCellNum();
        for(int r=0; r<=rowCount; r++){
            XSSFRow row=sheet.getRow(r);
            for(int c=0; c<cellCount; c++){
               XSSFCell cell= row.getCell(c);
               switch (cell.getCellType()){
                   case STRING:
                       System.out.print(cell.getStringCellValue());

                       break;
                   case NUMERIC:
                       System.out.print(cell.getNumericCellValue());

                       break;
                   case BOOLEAN:
                       System.out.print(cell.getBooleanCellValue());

                       break;
                }
                System.out.print(" | ");

            }
            System.out.println();
        }
    }
}
