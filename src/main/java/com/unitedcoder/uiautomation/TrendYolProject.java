package com.unitedcoder.uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TrendYolProject {
    public static void main(String[] args) throws InterruptedException {

        //Define driver --chromedriver
        System.setProperty("webdriver.chrome.driver","/Users/user/MyApplications/chromedriver_mac_arm64/chromedriver");

        //Define chromedriver object
        WebDriver chromeDriver= new ChromeDriver();

        //Open Trendyol homepage
        chromeDriver.navigate().to("https://www.trendyol.com/");
        Thread.sleep(5000);

        //set window size
        chromeDriver.manage().window().maximize();

        //search an item on Trendyol
        WebElement searchBox=chromeDriver.findElement(By.xpath("//*[@id=\"sfx-discovery-search-suggestions\"]/div/div/input"));
        searchBox.sendKeys("Kadın elbise" + Keys.ENTER);
        chromeDriver.close();

    }
}
