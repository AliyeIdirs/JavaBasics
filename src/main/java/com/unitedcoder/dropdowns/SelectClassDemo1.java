package com.unitedcoder.dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectClassDemo1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver= new ChromeDriver(options);
        driver.get("https://libgen.is/");
        WebElement downloadType= driver.findElement(By.name("open"));

        Select select= new Select(downloadType);
//        select.selectByVisibleText("Resumed dl with translit filename");
//        select.selectByValue("2");
        List<WebElement> option= select.getOptions(); //set all the options in one List
/*        for(int i=0; i<option.size();i++){  //for loop
            String optionText=option.get(i).getText();
            if(optionText.equalsIgnoreCase("Open file in browser")){
                option.get(i).click();
                break;
            }
        }*/

        for(WebElement element:option){  //foreach loop
            System.out.println(element.getText());
            if(element.getText().equalsIgnoreCase("Open file in browser")){
                element.click();
            }
        }
        Thread.sleep(3000);

        driver.close();
        driver.quit();
    }
}
