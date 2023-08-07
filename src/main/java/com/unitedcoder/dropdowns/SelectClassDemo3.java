package com.unitedcoder.dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectClassDemo3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.facebook.com/signup/");
        driver.manage().window().maximize();
        WebElement month=driver.findElement(By.name("birthday_month"));
        List<WebElement> option= driver.findElements(By.xpath("//*[@id=\"month\"]/option"));
        for (int i=0; i<option.size(); i++){
            System.out.println(option.get(i).getText());
        }

        driver.close();
        driver.quit();
    }
}
