package com.unitedcoder.methodtutorial;

import com.unitedcoder.cubecartautomation.CustomerInfo;
import com.unitedcoder.cubecartautomation.LoginUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomerObjectMethods {

    // login  add customer  delete customer  edit customer
    WebDriver driver;

    //set default constructor
    public CustomerObjectMethods() {
    }


    //set constructor with WebDriver parameter
    public CustomerObjectMethods(WebDriver driver) {
        this.driver = driver;
    }

    //login method
    public void logIn(LoginUser loginUser){
        WebElement userNameField= driver.findElement(By.id("username"));
        loginUser.setUserName("testautomation1");
        userNameField.sendKeys(loginUser.getUserName());
        WebElement passwordField=driver.findElement(By.id("password"));
        loginUser.setPassword("automation123!");
        passwordField.sendKeys(loginUser.getPassword());
        WebElement loginButton=driver.findElement(By.id("login"));
        loginButton.click();
    }


    //add customer method
    public void addCustomer(CustomerInfo customerInfo){
        driver.findElement(By.linkText("Customer List")).click();
        driver.findElement(By.xpath("//a[contains(text(),\"Add Customer\")]")).click();
        driver.findElement(By.id("cust-title")).sendKeys(customerInfo.getTitle());
        driver.findElement(By.name("customer[first_name]")).sendKeys(customerInfo.getFirstName());
        driver.findElement(By.id("cust-lastname")).sendKeys(customerInfo.getLastName());
        WebElement typeDropdown= driver.findElement(By.id("cust-type"));
        Select select = new Select(typeDropdown);
        //select.selectByVisibleText(TypeDropDownValue.Unregistered_Customer.name());
        select.selectByValue("2");
        driver.findElement(By.id("cust-email")).sendKeys(customerInfo.getEmail());
        driver.findElement(By.name("save")).click();
    }

    // verify customer added successfully
    public boolean verifyCustomerAddedSuccessfully(){
        WebElement successMessage=driver.findElement(By.xpath
                ("//*[contains(text(),'Customer successfully added.')]"));
        if(successMessage.isDisplayed()){
            System.out.println("Customer added successfully!");
            return true;
        }else{
            System.out.println("Add customer Failed!!!");
            return false;
        }
    }


    //logOut method
    public void logOut(){
        WebElement logOutLink=driver.findElement(By.cssSelector(".fa.fa-sign-out"));
        logOutLink.click();

    }

    // close and quit browser method
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
