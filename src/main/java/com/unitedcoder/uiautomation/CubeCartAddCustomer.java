package com.unitedcoder.uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CubeCartAddCustomer {
    public static void main(String[] args) {

        //Define driver-- chromedriver
        System.setProperty("webdriver.chrome.driver","/Users/user/MyApplications/chromedriver_mac_arm64/chromedriver");

        //Define chromeDriver object
        WebDriver chromeDriver= new ChromeDriver();

        //Navigate to CubeCart Homepage
        chromeDriver.get("http://cubecartuat.unitedcoder.com/admin_tu8sml.php?");
        chromeDriver.manage().window().maximize();
        chromeDriver.findElement(By.id("username")).sendKeys("testautomation1");
        chromeDriver.findElement(By.name("password")).sendKeys("automation123!");
        chromeDriver.findElement(By.name("login")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"menu_Customers\"]/li[1]/a")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"tab_control\"]/div[3]/a")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"general\"]/fieldset[1]/div[1]/span/img")).isSelected();
        chromeDriver.findElement(By.name("customer[first_name]")).sendKeys("Michle");
        chromeDriver.findElement(By.name("customer[last_name]")).sendKeys("Corse");
        chromeDriver.findElement(By.name("customer[email]")).sendKeys("michlecorse@gmail.com");
        chromeDriver.findElement(By.name("save")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"header\"]/span/a[2]")).click();
        chromeDriver.close();
        chromeDriver.quit();

    }
}
