package com.unitedcoder.homework.week13cubecartautomation;

import java.util.List;

public class TestRunner extends Methods{
    public static void main(String[] args) {
        String testDataFile = "TestDataFolders/Week13TestData/ProductInfo.xlsx";

        openBrowser();

        logIn();

        List<Product> productsList = readProductInfo(testDataFile, "ProductInfo");

        addProducts(productsList);

        bulkPriceChange(productsList,  DataBase.priceChangeAction(), DataBase.priceAmount(), DataBase.priceOption());

        for(Product product:productsList) {
            addReview(product.getProductName(), DataBase.reviewContent());
            break;
        }
        for(Product product:productsList) {
            updateReview(product.getProductName());
            break;
        }
        for(Product product:productsList){
            deleteReview(product.getProductName());
            break;
        }
        logOut();
        tearDown();

        writeTestReport("TestReport"+getCurrentTime()+".xlsx","TestReport",reportContent);

    }
}
