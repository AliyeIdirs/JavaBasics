package com.unitedcoder.homework.week11cubecartproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.security.auth.login.FailedLoginException;
import java.time.Duration;

public class BaseClass {
   public static WebDriver driver;

    public static void openBrowser(String url){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver= new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void logIn(AdminUser adminUser) {
            WebElement userNameField = driver.findElement(By.id("username"));
            userNameField.sendKeys(adminUser.getUserName());
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys(adminUser.getPassword());
            WebElement loginButton = driver.findElement(By.id("login"));
            loginButton.click();
            try {
                if (!adminUser.getUserName().equalsIgnoreCase("testautomation2") ||
                        !adminUser.getPassword().equalsIgnoreCase("automation123!")) {
                    System.out.println("Invalid username or password");
                    throw new FailedLoginException();
                }
            } catch (FailedLoginException e) {
                e.getLocalizedMessage();
            }
    }
    public static boolean verifyLogin(){
            try {
                WebElement dashBoard = driver.findElement(By.xpath("//*[@id=\"dashboard\"]/h3"));
                if (dashBoard.getText().equalsIgnoreCase("dashboard"))
                    System.out.println("Login Successful");
                return true;
            }
            catch(Exception e) {
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

    //Thread.sleep
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
    public static void fluentWait(WebElement element,int timeout){
        Wait<WebDriver> wait= new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
