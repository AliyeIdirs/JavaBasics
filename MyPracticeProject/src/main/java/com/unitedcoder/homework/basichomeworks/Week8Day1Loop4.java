package com.unitedcoder.homework.basichomeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Week8Day1Loop4 {
    public static void main(String[] args) {
        for (int i=0;i<3; i++) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver= new ChromeDriver(chromeOptions);
            driver.navigate().to("https://www.google.com/");
            driver.close();
        }
    }
}
