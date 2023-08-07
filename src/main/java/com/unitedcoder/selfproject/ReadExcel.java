package com.unitedcoder.selfproject;

import com.unitedcoder.homework.week13cubecartautomation.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcel {
    public List<Product> readProductInfo(String fileName, String sheetName) {

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
        List<Product> products = new ArrayList<>();
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        for (int r = 1; r <= rowCount; r++) {
            XSSFRow row = sheet.getRow(r);
            int c = 0;
            XSSFCell status = row.getCell(c);
            XSSFCell productName = row.getCell(++c);
            XSSFCell manufacturer = row.getCell(++c);
            XSSFCell condition = row.getCell(++c);
            XSSFCell productCode = row.getCell(++c);
            XSSFCell autoGenerateProductCode = row.getCell(++c);
            XSSFCell weight = row.getCell(++c);
            XSSFCell dimensionUnit = row.getCell(++c);
            XSSFCell width = row.getCell(++c);
            XSSFCell height = row.getCell(++c);
            XSSFCell depth = row.getCell(++c);
            XSSFCell includeInFeaturedProduct = row.getCell(++c);
            XSSFCell includeInLatestProduct = row.getCell(++c);
            XSSFCell availableForPurchase = row.getCell(++c);
            XSSFCell listDate = row.getCell(++c);
            XSSFCell useStockLevel = row.getCell(++c);
            XSSFCell stockLevel = row.getCell(++c);
            XSSFCell stockLevelWarning = row.getCell(++c);
            XSSFCell upcCode = row.getCell(++c);
            XSSFCell eanCode = row.getCell(++c);
            XSSFCell janCode = row.getCell(++c);
            XSSFCell isbnCode = row.getCell(++c);
            XSSFCell gtinCode = row.getCell(++c);
            XSSFCell mpnCode = row.getCell(++c);
            XSSFCell googleCategory = row.getCell(++c);
            products.add(new Product(String.valueOf(status.getBooleanCellValue()), productName.getStringCellValue(), manufacturer.getStringCellValue(),
                    condition.getStringCellValue(), productCode.getStringCellValue(), String.valueOf(autoGenerateProductCode.getBooleanCellValue()),
                    weight.getNumericCellValue(), dimensionUnit.getStringCellValue(), width.getNumericCellValue(), height.getNumericCellValue(),
                    depth.getNumericCellValue(), String.valueOf(includeInFeaturedProduct.getBooleanCellValue()), String.valueOf(includeInLatestProduct.getBooleanCellValue()),
                    String.valueOf(availableForPurchase.getBooleanCellValue()), listDate.getStringCellValue(), String.valueOf(useStockLevel.getBooleanCellValue()),
                    (int) stockLevel.getNumericCellValue(), (int) stockLevelWarning.getNumericCellValue(), upcCode.getStringCellValue(),
                    eanCode.getStringCellValue(), janCode.getStringCellValue(), isbnCode.getStringCellValue(), gtinCode.getStringCellValue(),
                    mpnCode.getStringCellValue(), googleCategory.getStringCellValue()));

        }
        System.out.println(products);
        return products;

    }
}
