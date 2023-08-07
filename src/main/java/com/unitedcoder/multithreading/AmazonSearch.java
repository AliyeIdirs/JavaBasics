package com.unitedcoder.multithreading;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonSearch extends Thread{
    private final String keyWords;
    public AmazonSearch(String keyWords){
        this.keyWords=keyWords;
    }
    public void run(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://www.amazon.com");
        driver.manage().window().maximize();
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(keyWords + Keys.ENTER);
        WebElement result= driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]",keyWords)));
        if (result.isDisplayed()){
            System.out.println("Test passed.");
        }else{
            System.out.println("Test failed.");
        }
        driver.close();
    }
}
