package com.unitedcoder.cubecartautomation;

import com.unitedcoder.configutility.UiUtility;
import com.unitedcoder.homework.week11cubecartproject.AdminUser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
   static WebDriver driver;
   static UiUtility uiUtility;

    public static void openBrowser(String url){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver= new ChromeDriver(options);
        uiUtility=new UiUtility(driver);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static boolean logIn(AdminUser adminUser) {
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys(adminUser.getUserName());
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(adminUser.getPassword());
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        uiUtility.takeScreenShot(adminUser.getUserName()+System.currentTimeMillis()+".jpg");
            try {
                WebElement dashBoard = driver.findElement(By.xpath("//*[@id=\"dashboard\"]/h3"));
                if (dashBoard.getText().equalsIgnoreCase("dashboard"))
                    System.out.println("Login Successful");
                return true;
            }
            catch(Exception e) {
                WebElement failMessage= driver.findElement(By.xpath("//li[contains(text(),\"Invalid username or password\")]"));
                if(failMessage.isDisplayed()){
                    System.out.println("Invalid username or password");
                }
                System.out.println("Login failed.");
                return false;
            }

    }

    public static boolean login( String userName, String password) {
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys(userName);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        uiUtility.takeScreenShot(userName+System.currentTimeMillis()+".jpg");
        try {
            WebElement dashBoard = driver.findElement(By.xpath("//*[@id=\"dashboard\"]/h3"));
            if (dashBoard.getText().equalsIgnoreCase("dashboard"))
                System.out.println("Login Successful");
            return true;
        }
        catch(Exception e) {
            WebElement failMessage= driver.findElement(By.xpath("//li[contains(text(),\"Invalid username or password\")]"));
            if(failMessage.isDisplayed()){
                System.out.println("Invalid username or password");
            }
            System.out.println("Login failed.");
            return false;
        }

    }

    public  static void logOut(){
        WebElement logOutLink=driver.findElement(By.cssSelector(".fa.fa-sign-out"));
        logOutLink.click();
    }

    public static void tearDown(){
        driver.close();
        driver.quit();
    }

    //Waits in Selenium
    //Thread.sleep method
    public static void sleep(int second){
        try {
            Thread.sleep(second* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Implicit wait
    public static void implicitWait(int second){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    }

    //Explicit wait
    public static void explicitWait(WebElement element, int timeout){
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Fluent wait
    public static void fluentWait(WebDriver driver,WebElement element){
        Wait<WebDriver> wait= new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
