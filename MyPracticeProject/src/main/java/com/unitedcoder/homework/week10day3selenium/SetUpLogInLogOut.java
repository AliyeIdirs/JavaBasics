package com.unitedcoder.homework.week10day3selenium;

import com.unitedcoder.homework.week10day3constructor.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetUpLogInLogOut {

     public static WebDriver driver;

    //driver setup method
    public static void driverSetUp(String url){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver= new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

    }

    //Login Method
    public static void logIn(User user){
        WebElement userNameField= driver.findElement(By.id("username"));
        userNameField.sendKeys(user.getUserName());
        WebElement passwordField=driver.findElement(By.id("password"));
        passwordField.sendKeys(user.getPassword());
        WebElement loginButton=driver.findElement(By.id("login"));
        loginButton.click();
    }

    //LogOut Method
    public static void logOut(){
        WebElement logOutLink=driver.findElement(By.cssSelector(".fa.fa-sign-out"));
        logOutLink.click();
    }

    //TearDown
    public static void tearDown(){
        driver.close();
        driver.quit();
    }
}
