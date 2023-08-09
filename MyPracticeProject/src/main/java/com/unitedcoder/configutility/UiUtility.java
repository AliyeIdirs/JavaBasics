package com.unitedcoder.configutility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class UiUtility {
    private final WebDriver driver;

    private final int timeout=Integer.parseInt(ApplicationConfig
            .readConfigProperties("config.properties","timeout"));


    public UiUtility(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void takeScreenShot(String imageName){
        TakesScreenshot screenshot=(TakesScreenshot) driver;
        File screenShortFile=screenshot.getScreenshotAs(OutputType.FILE);
        String folder=ApplicationConfig.readConfigProperties("config.properties",
                "screenshot");
        File file=new File(folder+File.separator+imageName);
        try {
            FileUtils.copyFile(screenShortFile,file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
