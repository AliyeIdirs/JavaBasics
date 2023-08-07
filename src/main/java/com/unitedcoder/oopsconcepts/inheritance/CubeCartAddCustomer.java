package com.unitedcoder.oopsconcepts.inheritance;

import com.unitedcoder.cubecartautomation.CustomerInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CubeCartAddCustomer extends BaseClass {
    public static void main(String[] args) {
        openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        logIn("testautomation1","automation123!");
        CustomerInfo customerInfo = new CustomerInfo("Aynigar"+System.currentTimeMillis(),
                "Alim"+System.currentTimeMillis(),"Miss",
                "aynigar"+System.currentTimeMillis()+"@gmail.com");

        addCustomer(customerInfo);
        logOut();
        tearDown();

    }
        public static boolean addCustomer(CustomerInfo customerInfo){
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

        // verify customer added successfully
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
}


