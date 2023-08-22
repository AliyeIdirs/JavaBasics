package com.unitedcoder.methodtutorial;

import com.unitedcoder.cubecartautomation.CustomerInfo;
import com.unitedcoder.cubecartautomation.LoginUser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddCustomerTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver= new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.navigate().to("http://cubecartuat.unitedcoder.com/admin_tu8sml.php?");

        LoginUser loginUser= new LoginUser("testautomaiton1","automaiton123!");

        CustomerInfo customerInfo = new CustomerInfo("Aynigar"+System.currentTimeMillis(),
                "Alim"+System.currentTimeMillis(),"Miss",
                "aynigar"+System.currentTimeMillis()+"@gmail.com");

        CustomerObjectMethods objectMethods= new CustomerObjectMethods(driver);
        objectMethods.logIn(loginUser);
        objectMethods.addCustomer(customerInfo);
        objectMethods.verifyCustomerAddedSuccessfully();
        objectMethods.logOut();
        objectMethods.tearDown();

    }
}
