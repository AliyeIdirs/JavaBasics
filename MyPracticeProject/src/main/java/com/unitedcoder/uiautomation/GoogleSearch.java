package com.unitedcoder.uiautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class GoogleSearch {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.safaridriver().setup();
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new SafariDriver(safariOptions);

        //Set browser size
        driver.navigate().to("https://www.google.com");
        Dimension dimension= new Dimension(700,800);
        driver.manage().window().setSize(dimension);
        driver.manage().window().maximize();
        driver.findElement(By.id("APjFqb")).sendKeys("What is SDET");
        Actions actions=new Actions(driver);
        actions.keyDown(Keys.ENTER).perform();
        Thread.sleep(5000);
        driver.quit();
    }
}