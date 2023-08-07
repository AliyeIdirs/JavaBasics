package com.unitedcoder.excelfile;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriteWithArray {
    public static void main(String[] args) throws IOException {
        Object[][] studentInfo={
                {"Student_ID","Student_Name","Score"},
                {11,"Tom",90},
                {12,"Mike",80},
                {13,"David",99}
        };
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Class-A");
        int rows=studentInfo.length;
        int column=studentInfo[0].length;
        for(int r=0; r<rows;r++){
            XSSFRow row=sheet.createRow(r);
            for(int c=0; c<column; c++){
                XSSFCell cell=row.createCell(c);
                Object contents=studentInfo[r][c];
                if(contents instanceof String){
                    cell.setCellValue((String)contents);
                }if(contents instanceof Integer){
                    cell.setCellValue(((Integer)contents));
                }

            }

        }
        String fileName="testdatafolders/student_info.xlsx";
        File file=new File(fileName);
        FileOutputStream outputStream=new FileOutputStream(file);
        workbook.write(outputStream);
        workbook.close();

    }
}
