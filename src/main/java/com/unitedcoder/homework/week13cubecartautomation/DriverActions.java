package com.unitedcoder.homework.week13cubecartautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DriverActions extends BaseFunctions{
    static WebDriver driver;

    public static void openBrowser(){
        reportContent.add(new String[]{"TestId", "TestName", "TestModule", "TestType", "ExecutedAt", "ExecutedBy", "TestStatus", "Note"});
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver= new ChromeDriver(options);
        driver.get(readConfigFile(configFile,"URL"));
        driver.manage().window().maximize();
    }
    public static boolean logIn() {
        try {
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys(readConfigFile(configFile,"username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(readConfigFile(configFile,"password"));
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        String configValue=readConfigFile(configFile,"screenshot");
        takeScreenShot(configValue+separator+"LoginTest"+getCurrentTime()+".jpg");
            WebElement dashBoard = driver.findElement(By.xpath("//*[@id=\"dashboard\"]/h3"));
            if (dashBoard.getText().equalsIgnoreCase("dashboard"))
                System.out.println("Login Successful");
            testStatus="Passed";
           reportContent.add(new String[]{"1","Login","Dashboard","SmokeTest",getCurrentTime(),
                    getCurrentUser(),testStatus,"Note"});
            return true;
        }
        catch(Exception e) {
            WebElement failMessage= driver.findElement(By.xpath("//li[contains(text(),\"Invalid username or password\")]"));
            if(failMessage.isDisplayed()){
                System.out.println("Invalid username or password");
            }
            System.out.println("Login failed.");
            testStatus="Failed";
            reportContent.add(new String[]{"1","Login","Dashboard","SmokeTest",getCurrentTime(),
                    getCurrentUser(),testStatus,"Note"});
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

    public static void takeScreenShot(String fileName){
        TakesScreenshot screenshot=(TakesScreenshot)driver;
        File screenShotFile=screenshot.getScreenshotAs(OutputType.FILE);
        File file=new File(mainFolder+separator+fileName);
        try {
            FileUtils.copyFile(screenShotFile,file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fluentWait(WebDriver driver, WebElement element,String text){
        Wait<WebDriver> wait= new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout*3))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.textToBePresentInElementValue(element,text));
    }

    public static void sleep(){
        try {
            Thread.sleep(timeout* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
