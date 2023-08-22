package com.unitedcoder.excelfile;


import com.unitedcoder.cubecartautomation.LoginUser;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExcelUtility {

    //method to read from excel cell
    public String readFromExcelCell(String fileName, String sheetName, int rowNumber,int cellNumber){
        FileInputStream inputStream= null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook= null;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet=workbook.getSheet(sheetName);
        XSSFRow row=sheet.getRow(rowNumber);
        String cellValue=null;
        if(row==null){
            System.out.println("Empty row!!");
        }else{
            XSSFCell cell=row.getCell(cellNumber);
            try {
                if (cell == null) {
                    System.out.println("Empty cell!!");
                }

            CellType cellType= Objects.requireNonNull(cell).getCellType();
            switch (cellType){
                case NUMERIC:
                    cellValue=String.valueOf(cell.getNumericCellValue());
                    System.out.println(cellValue);
                    break;
                case STRING:
                    cellValue=cell.getStringCellValue();
                    System.out.println(cellValue);
                    break;
            }
            }catch(NullPointerException e){
                e.getMessage();
            }
        }
        return cellValue;
    }

    public List<LoginUser> readFromMultipleCell(String fileName, String sheetName) throws IOException {
        FileInputStream inputStream;
            inputStream = new FileInputStream(fileName);
        XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
        XSSFSheet sheet=workbook.getSheet(sheetName);
        int rowCount=sheet.getLastRowNum();
        List<LoginUser> loginUsers= new ArrayList<>();
        for(int r=1; r<=rowCount; r++){
            XSSFRow row=sheet.getRow(r);
            XSSFCell userName=row.getCell(0);
            XSSFCell password=row.getCell(1);
            loginUsers.add(new LoginUser(userName.getStringCellValue(),password.getStringCellValue()));
        }
        return loginUsers;
    }

    public void writeToExcelCells(String fileName, String sheetName, List<String> content){
        //define a file to write
        File excelFile=new File(fileName);
        //define a work book
        XSSFWorkbook workbook=new XSSFWorkbook();
        //create sheet
        XSSFSheet sheet= workbook.createSheet(sheetName);
        int numberOfRows=content.size();
        for(int rowNumber=0; rowNumber<numberOfRows;rowNumber++){
            XSSFRow row=sheet.createRow(rowNumber);
            String[] rowContent=content.get(rowNumber).split(",");
            int totalCell=rowContent.length;
            for (int cellNumber=0; cellNumber<totalCell; cellNumber++){
                XSSFCell cell=row.createCell(cellNumber);
                //add contents to the cell
                cell.setCellValue(rowContent[cellNumber]);
            }

        }
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(excelFile);
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
