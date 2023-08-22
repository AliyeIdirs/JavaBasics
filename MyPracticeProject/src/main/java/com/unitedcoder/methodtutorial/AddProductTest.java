package com.unitedcoder.methodtutorial;

import com.unitedcoder.cubecartautomation.LoginUser;
import com.unitedcoder.cubecartautomation.ProductInfo;
import org.openqa.selenium.WebDriver;

public class AddProductTest {
    static WebDriver driver;

    public static void main(String[] args) {
        ProductObjectMethod productObjectMethod= new ProductObjectMethod(driver);

        LoginUser loginUser= new LoginUser("testautomation1","automation123!");

        ProductInfo productInfo=new ProductInfo("Long Dress"+System.currentTimeMillis(),
                "MN"+System.currentTimeMillis(),"0.5kg","20cm","30cm","5cm", null,
                500,100,"UPC"+System.currentTimeMillis(),"EAN"+System.currentTimeMillis(),
                "JAN"+System.currentTimeMillis(),"ISBN"+System.currentTimeMillis(),
                "GTIN"+System.currentTimeMillis(),"MPN"+System.currentTimeMillis());

        productObjectMethod.driverSetUp();
        productObjectMethod.logIn(loginUser);
        productObjectMethod.addProduct(productInfo);
        productObjectMethod.verifyAddProductSuccessful();
        productObjectMethod.logOut();
        productObjectMethod.tearDown();


    }

}
