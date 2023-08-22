package com.unitedcoder.selfproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CubeCartAddMultipleCustomer {
    public static void main(String[] args) throws InterruptedException {

        //Define driver-- chromedriver
        System.setProperty("webdriver.chrome.driver","/Users/user/MyApplications/chromedriver_mac_arm64/chromedriver");

        //Define chromeDriver object
        WebDriver chromeDriver= new ChromeDriver();

        //Navigate to CubeCart Homepage
        chromeDriver.get("http://cubecartuat.unitedcoder.com/admin_tu8sml.php?");
        chromeDriver.manage().window().maximize();
        String[] credential={"testautomation1","automation123!"};
        chromeDriver.findElement(By.id("username")).sendKeys(credential[0]);
        chromeDriver.findElement(By.name("password")).sendKeys(credential[1]);
        chromeDriver.findElement(By.name("login")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"menu_Customers\"]/li[1]/a")).click();
        String[][] infoList= {
                {"David1","Beckham1","david1@beckham.com"},
                {"Sara2","Jonson2","saraj2@gmail.com"},
                {"Jack3","Shepherd3","jack213@yahoo.com"}};
        for(int i=0;i< infoList.length;i++) {
            chromeDriver.findElement(By.xpath("//*[@id=\"tab_control\"]/div[3]/a")).click();
            chromeDriver.findElement(By.xpath("//*[@id=\"general\"]/fieldset[1]/div[1]/span/img")).isSelected();
            for (int j = 0; j < infoList.length; j++){
                chromeDriver.findElement(By.name("customer[first_name]")).sendKeys(infoList[i][j]);
                chromeDriver.findElement(By.name("customer[last_name]")).sendKeys(infoList[i][j+1]);
                chromeDriver.findElement(By.name("customer[email]")).sendKeys(infoList[i][j+2]);
                chromeDriver.findElement(By.name("save")).click();
                break;
        }
        }
        chromeDriver.findElement(By.xpath("//*[@id=\"header\"]/span/a[2]")).click();
        chromeDriver.close();
        chromeDriver.quit();

    }
}
