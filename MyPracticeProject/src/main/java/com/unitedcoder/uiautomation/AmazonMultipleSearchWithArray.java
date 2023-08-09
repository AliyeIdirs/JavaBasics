package com.unitedcoder.uiautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class AmazonMultipleSearchWithArray {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver = new ChromeDriver(chromeOptions);

        //Set browser size
        DateTime browserOpenTime= new DateTime();
        driver.navigate().to("https://www.amazon.com");
        driver.manage().window().maximize();
        String[] productNames={"Ipad","Java Oracle Book","Hard Disk"};
        for (String keyWords:productNames ) {
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys(keyWords + Keys.ENTER);
            driver.navigate().back();
        }
        driver.close();
        driver.quit();

        DateTime browserCloseTime= new DateTime();
        Period period= new Period(browserOpenTime,browserCloseTime, PeriodType.seconds());
        System.out.println("Total search time: "+period.getSeconds() +" seconds.");
    }
}