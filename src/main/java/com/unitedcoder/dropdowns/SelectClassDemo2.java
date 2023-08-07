package com.unitedcoder.dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectClassDemo2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.facebook.com/signup/");
        driver.manage().window().maximize();

        WebElement day= driver.findElement(By.id("day"));
        Select selectDay= new Select(day);
        List<WebElement> days=selectDay.getOptions();
        for (int i=0; i<days.size(); i++){
            String dayValue=days.get(i).getText();
            System.out.print(dayValue+" ");
            if(dayValue.equalsIgnoreCase("18")){
                days.get(i).click();
                break;
            }
        }
        System.out.println();

        WebElement month=driver.findElement(By.name("birthday_month"));
        Select selectMonth= new Select(month);
        List<WebElement> months=selectMonth.getOptions();
        for(WebElement element:months){
            System.out.print(element.getText()+" ");
            if (element.getText().equalsIgnoreCase("Ağu")){
                element.click();
            }
        }

        WebElement year= driver.findElement(By.id("year"));
        Select selectYear= new Select(year);
        selectYear.selectByValue("1995");


        driver.close();
        driver.quit();
    }
}
