package com.unitedcoder.excelfile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadFromExcelDemo2 {
    public static void main(String[] args) {
        String projectPath=System.getProperty("user.dir");
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(projectPath+File.separator+
                    "testdatafolders/testReport.xlsx");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        readContent(inputStream);

    }

    public static void readContent(FileInputStream excelFile) {
        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(excelFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            System.out.println("\nRow Number: " + row.getRowNum());
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (cell.getCellType() == CellType.STRING) {
                    System.out.print(cell.getStringCellValue() + ",");
                }
                if (cell.getCellType() == CellType.NUMERIC) {
                    System.out.print(cell.getNumericCellValue());
                }
            }
            try {
                excelFile.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
