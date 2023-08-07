package com.unitedcoder.uiautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MultipleClick {
    public static void main(String[] args) throws InterruptedException {

        //define driver --chromedriver
        WebDriverManager.chromedriver().setup();

        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        //define chrome driver object
        ChromeDriver driver= new ChromeDriver(options);
        driver.get("https://www.turkishairlines.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"cabinTypeSelector\"]/div")).click();
        for (int i=0; i<4; i++) {
            driver.findElement(By.name("upperCountSpinner")).click();
            Thread.sleep(3000);
        }


        //driver.close();

    }
}
