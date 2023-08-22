package com.unitedcoder.excelfile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcelDataWithIterator {

    public static void main(String[] args) {
        ReadExcelDataWithIterator iterator=new ReadExcelDataWithIterator();
        List<String> customerInfo= iterator.getInfo("David","CustomerInfo",1);
        System.out.println(customerInfo);
    }
    public List<String> getInfo(String name,String sheetName,int cellNo){
        String filePath="testdatafolders/myFile.xlsx";
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int sheetsCount=workbook.getNumberOfSheets();
        List<String> info=new ArrayList<>();
        for(int i=0;i<sheetsCount;i++){
            if(workbook.getSheetName(i).equalsIgnoreCase(sheetName)){
                XSSFSheet sheet=workbook.getSheetAt(i);
                for (Row r : sheet) {
                    if (r.getCell(cellNo).getStringCellValue().equalsIgnoreCase(name)) {
                        Iterator<Cell> cellIterator = r.cellIterator();
                        while (cellIterator.hasNext()) {
                            Cell c = cellIterator.next();
                            if (c.getCellType() == CellType.STRING) {
                                info.add(c.getStringCellValue());
                            } else {
                                info.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                    }
                }
            }
        }
        return info;
    }
}
