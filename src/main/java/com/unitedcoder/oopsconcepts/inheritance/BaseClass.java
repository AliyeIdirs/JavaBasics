package com.unitedcoder.oopsconcepts.inheritance;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
   static WebDriver driver;

    public static void openBrowser(String url){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver= new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void logIn(String userName, String password){
            WebElement userNameField= driver.findElement(By.id("username"));
            userNameField.sendKeys(userName);
            WebElement passwordField=driver.findElement(By.id("password"));
            passwordField.sendKeys(password);
            WebElement loginButton=driver.findElement(By.id("login"));
            loginButton.click();
    }

    public  static void logOut(){
        WebElement logOutLink=driver.findElement(By.cssSelector(".fa.fa-sign-out"));
        logOutLink.click();
    }

    public static void tearDown(){
        driver.close();
        driver.quit();
    }

}
