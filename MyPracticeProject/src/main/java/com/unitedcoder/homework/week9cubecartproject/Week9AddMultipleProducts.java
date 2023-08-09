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

public class Week9AddMultipleProducts {
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

        WebElement products=driver.findElement(By.id("nav_products"));
        products.click();

        String[][] productList={{"Camera Machine"+System.currentTimeMillis(),"100","EAN"+System.currentTimeMillis(),"5000","4500","1500"},
                {"Dining Equipment"+System.currentTimeMillis(),"50","EAN"+System.currentTimeMillis(),"7000","6000","3000"},
                {"Book Kit"+System.currentTimeMillis(),"200","EAN"+System.currentTimeMillis(),"1000","850","500"}
        };
        Thread.sleep(2000);
        DateTime beginTime= new DateTime();
        for(int i=0; i< productList.length;i++){
        WebElement addProduct=driver.findElement(By.linkText("Add Product"));
        addProduct.click();

            for (int j=0; j<productList[i].length;j++){
        WebElement productName= driver.findElement(By.id("name"));
        productName.sendKeys(productList[i][j]);

        WebElement stockLevel= driver.findElement(By.id("stock_level"));
        stockLevel.sendKeys(productList[i][j+1]);

        WebElement eanCode= driver.findElement(By.id("ean"));
        eanCode.sendKeys(productList[i][j+2]);

        WebElement pricing= driver.findElement(By.xpath("//a[@href=\"#pricing\"]"));
        Thread.sleep(2000);
        pricing.click();

        WebElement retailPrice= driver.findElement(By.id("price"));
        retailPrice.sendKeys(productList[i][j+3]);

        WebElement salePrice= driver.findElement(By.id("sale_price"));
        salePrice.sendKeys(productList[i][j+4]);

        WebElement costPrice=driver.findElement(By.id("cost_price"));
        costPrice.sendKeys(productList[i][j+5]);

        WebElement taxIncluded= driver.findElement(By.xpath("//*[@id=\"group_0\"]/fieldset[1]/div[5]/span/img"));
        taxIncluded.click();

        WebElement taxClass= driver.findElement(By.id("tax_type"));
        taxClass.click();
        Thread.sleep(2000);
        WebElement taxType=driver.findElement(By.xpath("//option[@value='1']"));
        taxType.click();

        WebElement categories= driver.findElement(By.xpath("//a[@href=\"#category\"]"));
        categories.click();
        Thread.sleep(3000);

        WebElement testCategory= driver.findElement(By.id("cat_1"));
        testCategory.click();

        Thread.sleep(3000);

        WebElement saveButton= driver.findElement(By.xpath("//*[@id=\"page_content\"]/form/div[10]/input[3]"));
        saveButton.click();
        break;

            }
            System.out.println(i+1 +" product added successfully");
        }
        DateTime endTime=new DateTime();
        Period period=new Period(beginTime,endTime, PeriodType.seconds());
        driver.close();
        driver.quit();

        System.out.println("Multiple products are added successfully!");
        System.out.println("Total operation time is: "+period.getSeconds()+" seconds.");
    }
}
