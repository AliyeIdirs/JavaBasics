package com.unitedcoder.io;

import com.unitedcoder.cubecartautomation.LoginUser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CubeCartLoginTestWriteResult {
    public static void main(String[] args) throws InterruptedException {
        LoginUser loginUser= new LoginUser();
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver= new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.navigate().to("http://cubecartuat.unitedcoder.com/admin_tu8sml.php?");
        WebElement userNameField= driver.findElement(By.id("username"));
        loginUser.setUserName("testautomation1");
        userNameField.sendKeys(loginUser.getUserName());
        WebElement passwordField=driver.findElement(By.id("password"));
        loginUser.setPassword("automation123!");
        passwordField.sendKeys(loginUser.getPassword());
        WebElement loginButton=driver.findElement(By.id("login"));
        loginButton.click();
        Thread.sleep(3000);

        //verify login test

        String testResult="";
        try {
            WebElement dashBoard = driver.findElement(By.xpath("//*[@id=\"dashboard\"]/h3"));

            if (dashBoard.getText().equalsIgnoreCase("dashboard"))
                System.out.println("Login Test Passed");
            testResult="Login Test Passed";
        }
        catch(Exception e) {
            System.out.println("Login Test Failed");
            testResult="Login Test Failed";
        }
        FileUtility fileUtility= new FileUtility();
        fileUtility.writeToFile("doc","logintestresult"+FileWriteDemo1.getCurrentDateTime(),
                ".txt",testResult);
        driver.quit();
    }
}
