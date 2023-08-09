package com.unitedcoder.uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {
    public static void main(String[] args) {

        //define driver --chromedriver
        System.setProperty("webdriver.chrome.driver","/Users/user/MyApplications/chromedriver_mac_arm64/chromedriver");

        //define chrome driver object
        WebDriver chromeDriver=new ChromeDriver();

        //open amazon home page
        chromeDriver.get("https://www.amazon.com/");
        //chromeDriver.navigate().to("https://www.amazon.com/");

        //set browser size
        chromeDriver.manage().window().maximize();
        WebElement searchBox=chromeDriver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("AirPod" +Keys.ENTER);
        chromeDriver.close();

    }
}
