package com.unitedcoder.uiautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MultipleWebSiteTest {
    public static void main(String[] args) throws InterruptedException {
        Map<String,String> website=new HashMap<>();
        website.put("Google","https://www.google.com");
        website.put("YouTube","https://www.youtube.com");
        website.put("Amazon","https://www.amazon.com");

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver = new ChromeDriver(chromeOptions);

        Set<String> keys=website.keySet();
        for(String k:keys){
            StopWatch watch= new StopWatch();
            watch.start();
            driver.get(website.get(k));
            if(driver.getTitle().contains(k)){
                System.out.println(k+" Opened successfully, Test passed.");
                watch.stop();
                System.out.println(k+" opened within "+watch.getTime(TimeUnit.MILLISECONDS)+" Millisecond");
            }
        }

        driver.close();
        driver.quit();

    }
}