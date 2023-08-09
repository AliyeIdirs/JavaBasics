package com.unitedcoder.cubecartautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CubeCartLoginTestWithArray {
    public static void main(String[] args) throws InterruptedException {
        String[] credential={"testautomation1","automation123!"};
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver= new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.navigate().to("http://cubecartuat.unitedcoder.com/admin_tu8sml.php?");
        WebElement userNameField= driver.findElement(By.id("username"));
        userNameField.sendKeys(credential[0]);
        WebElement passwordField=driver.findElement(By.id("password"));
        passwordField.sendKeys(credential[1]);
        WebElement loginButton=driver.findElement(By.id("login"));
        loginButton.click();
        Thread.sleep(3000);
        //very login test
        try {
            WebElement dashBoard = driver.findElement(By.xpath("//*[@id=\"dashboard\"]/h3"));
            if (dashBoard.getText().equalsIgnoreCase("dashboard"))
                System.out.println("Login Test Passed");
        }
        catch(Exception e) {
            System.out.println("Login Test Failed");
        }
        driver.close();
        driver.quit();
    }
}
