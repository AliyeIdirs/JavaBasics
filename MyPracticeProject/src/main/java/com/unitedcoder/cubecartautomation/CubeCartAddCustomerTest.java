package com.unitedcoder.cubecartautomation;

import com.unitedcoder.dropdowns.CustomerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CubeCartAddCustomerTest {
    public static void main(String[] args) throws InterruptedException {
        LoginUser loginUser= new LoginUser();
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        ChromeDriver driver= new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.navigate().to("http://cubecartuat.unitedcoder.com/admin_tu8sml.php?");
        WebElement userNameField= driver.findElement(By.id("username"));
        loginUser.setUserName("testautomation1");
        userNameField.sendKeys(loginUser.getUserName());
        WebElement passwordField=driver.findElement(By.id("password"));
        loginUser.setPassword("automation123!");
        passwordField.sendKeys(loginUser.getPassword());
        WebElement loginButton=driver.findElement(By.id("login"));
        loginButton.click();
        Thread.sleep(3000);

        //Add customer
        CustomerInfo customerInfo= new CustomerInfo("Aynigar"+System.currentTimeMillis(),
                "Alim"+System.currentTimeMillis(),"Miss",
                "aynigar"+System.currentTimeMillis()+"@gmail.com");
        driver.findElement(By.linkText("Customer List")).click();
        driver.findElement(By.xpath("//a[contains(text(),\"Add Customer\")]")).click();
        driver.findElement(By.id("cust-title")).sendKeys(customerInfo.getTitle());
        driver.findElement(By.name("customer[first_name]")).sendKeys(customerInfo.getFirstName());
        driver.findElement(By.id("cust-lastname")).sendKeys(customerInfo.getLastName());
        WebElement typeDropdown= driver.findElement(By.id("cust-type"));
        Select select = new Select(typeDropdown);
        select.selectByVisibleText(CustomerType.UNREGISTERED_CUSTOMER.getValue());
        //select.selectByValue("2");
        driver.findElement(By.id("cust-email")).sendKeys(customerInfo.getEmail());
        driver.findElement(By.name("save")).click();

        //Verify Add Customer
        WebElement successMessage=driver.findElement(By.xpath
                ("//*[contains(text(),'Customer successfully added.')]"));
        if(successMessage.isDisplayed()){
            System.out.println("Customer added successfully!");
        }else{
            System.out.println("Add customer Failed!!!");
        }
        WebElement logOutLink=driver.findElement(By.cssSelector(".fa.fa-sign-out"));
        logOutLink.click();

        driver.close();
        driver.quit();

    }
}
