package regressionsuit.week16junitproject;


import com.github.javafaker.Faker;
import com.unitedcoder.configutility.ApplicationConfig;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class FunctionLibrary extends TestBase{
    static int timeout= Integer.parseInt(ApplicationConfig.readConfigProperties("config.properties","timeout"));
    public static void waitElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitAlertPresent(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public void sleep(){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void sleep(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
