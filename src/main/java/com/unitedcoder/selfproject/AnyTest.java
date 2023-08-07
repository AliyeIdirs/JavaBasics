package com.unitedcoder.selfproject;


import com.unitedcoder.homework.week13cubecartautomation.BaseFunctions;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnyTest {
        public static void main(String[] args) {
            String fileName = "TestDataFolders/CubeCartAddProduct.xlsx";
            List<ExceObject> products = readFromExcel(fileName,"ProductInformations");
            System.out.println(products);
        }
        public static List<ExceObject> readFromExcel(String fileName, String sheetName){
            List<ExceObject> products = new ArrayList<>();
            FileInputStream inputStream;
            try {
                inputStream = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            XSSFWorkbook workbook;
            try {
                workbook = new XSSFWorkbook(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            for (int i=1;i<=rowCount;i++){
                XSSFRow row = sheet.getRow(i);
                int c = 0;
                XSSFCell productName = row.getCell(c);
                XSSFCell productCode = row.getCell(++c);
                XSSFCell productWeight = row.getCell(++c);
                XSSFCell productWidth = row.getCell(++c);
                XSSFCell productHeight = row.getCell(++c);
                XSSFCell productDepth = row.getCell(++c);
                XSSFCell stockLevel = row.getCell(++c);
                XSSFCell stockLevelWarning = row.getCell(++c);
                XSSFCell upcCode = row.getCell(++c);
                XSSFCell eanCode = row.getCell(++c);
                XSSFCell janCode = row.getCell(++c);
                XSSFCell isbnCode = row.getCell(++c);
                XSSFCell gtinCode = row.getCell(++c);
                XSSFCell mpnCode = row.getCell(++c);
                XSSFCell retailPrice = row.getCell(++c);
                XSSFCell salePrice = row.getCell(++c);
                XSSFCell costPrice = row.getCell(++c);
                XSSFCell minimumPurchase = row.getCell(++c);
                XSSFCell maximumPurchase = row.getCell(++c);
                XSSFCell quantity = row.getCell(++c);
                XSSFCell priceType = row.getCell(++c);
                products.add(new ExceObject(productName.getStringCellValue(),productCode.getStringCellValue(),
                        productWeight.getStringCellValue(),productWidth.getStringCellValue(),productHeight.getStringCellValue(),
                        productDepth.getStringCellValue(),String.valueOf(stockLevel.getNumericCellValue()),String.valueOf(stockLevelWarning.getNumericCellValue()),
                        String.valueOf(upcCode.getNumericCellValue()),String.valueOf(eanCode.getNumericCellValue()),
                        String.valueOf(janCode.getNumericCellValue()),isbnCode.getStringCellValue(),gtinCode.getStringCellValue(),
                                mpnCode.getStringCellValue(),retailPrice.getStringCellValue(),salePrice.getStringCellValue(),
                                costPrice.getStringCellValue(),String.valueOf(minimumPurchase.getNumericCellValue()),String.valueOf(maximumPurchase.getNumericCellValue()),
                                quantity.getStringCellValue(),priceType.getStringCellValue()));
            }

            return products;
        }


    }
