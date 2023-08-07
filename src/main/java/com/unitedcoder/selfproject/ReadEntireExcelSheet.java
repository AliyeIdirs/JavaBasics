package com.unitedcoder.selfproject;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadEntireExcelSheet {
    public static void main(String[] args) {
        ReadEntireExcelSheet readEntireExcelSheet=new ReadEntireExcelSheet();
        String fileName="testdatafolders/TestDataFile.xlsx";
        readEntireExcelSheet.readExcelSheet(fileName,"TestResult");

    }

    public String readExcelSheet(String fileName, String sheetName){
        String filePath=System.getProperty("user.dir")+ File.separator+fileName;
        StringBuilder builder=new StringBuilder();
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            int sheetCount = workbook.getNumberOfSheets();
            for (int i = 0; i < sheetCount; i++) {
                if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
                    XSSFSheet sheet = workbook.getSheetAt(i);
                    Iterator<Row> rowIterator = sheet.iterator();
                    while (rowIterator.hasNext()) {
                        Row row = rowIterator.next();
                        if (row == null) {
                            System.out.println("Empty row!!!");
                        } else {
                            Iterator<Cell> cellIterator = row.cellIterator();
                            while (cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                if (cell == null) {
                                    cell.setCellValue("Empty cell");
                                } else {
                                    if (cell.getCellType() == CellType.NUMERIC) {
                                        builder.append(cell.getNumericCellValue());
                                    } else if (cell.getCellType() == CellType.STRING) {
                                        builder.append(cell.getStringCellValue());
                                    } else if (cell.getCellType() == CellType.BOOLEAN) {
                                        builder.append(cell.getBooleanCellValue());
                                    } else if (cell.getCellType() == CellType.BLANK) {
                                        builder.append("Blank");
                                    } else if (cell.getCellType() == CellType._NONE) {
                                        builder.append("None");
                                    } else if (cell.getCellType() == CellType.ERROR) {
                                        builder.append(cell.getErrorCellValue());
                                    }
                                }
                                builder.append(",");
                            }

                        }
                        builder.append("\n");
                    }
                }
            }
        }catch (IOException e){
            e.getMessage();
        }
        System.out.println(builder);
        return builder.toString();
    }
}
