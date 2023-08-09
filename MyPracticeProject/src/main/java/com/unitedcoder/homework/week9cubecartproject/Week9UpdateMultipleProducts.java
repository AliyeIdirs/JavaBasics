package com.unitedcoder.homework.week9cubecartproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Week9UpdateMultipleProducts {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver= new ChromeDriver();

        driver.get("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        driver.manage().window().maximize();

        String[] credentials={"testautomation1","automation123!"};

        WebElement userNameField=driver.findElement(By.id("username"));
        WebElement passwordField=driver.findElement(By.name("password"));
        WebElement loginButton=driver.findElement(By.id("login"));
        userNameField.sendKeys(credentials[0]);
        passwordField.sendKeys(credentials[1]);
        loginButton.click();

        String[] productCode={"BOOFV4WI11","DIN8PZMP7","CAMHIC4Y94"};

        Thread.sleep(2000);
        DateTime beginTime=new DateTime();
        for(int i=0; i< productCode.length;i++) {

            driver.findElement(By.id("nav_products")).click();
            driver.findElement(By.linkText("Search Products")).click();
            Thread.sleep(1000);

            WebElement searchProductBar = driver.findElement(By.name("search[product]"));
            searchProductBar.click();
            Thread.sleep(1000);

            searchProductBar.sendKeys(productCode[i]);
           driver.findElement(By.cssSelector("#sidebar_content > div:nth-child(2) > form > input.go_search")).click();
            Thread.sleep(3000);

            String[] linkText={"Book Kit","Dining Equipment","Camera Machine"};
            for(int j=0; j< linkText.length;j++){
                driver.findElement(By.linkText(linkText[i])).click();
                WebElement stockLevel = driver.findElement(By.id("stock_level"));
                stockLevel.clear();
                int newStock= (int)(Math.random()*500+10);
                stockLevel.sendKeys(Integer.toString(newStock));
                WebElement saveButton = driver.findElement(By.cssSelector("input[value='Save'"));
                saveButton.click();
                break;
            }

        }

        DateTime endTime=new DateTime();
        Period period=new Period(beginTime,endTime, PeriodType.seconds());
        driver.close();
        driver.quit();

        System.out.println("Multiple products are updated successfully!");
        System.out.println("Total operation time is: "+period.getSeconds());
    }
}
