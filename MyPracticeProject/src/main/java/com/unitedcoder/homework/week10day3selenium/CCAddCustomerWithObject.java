package com.unitedcoder.homework.week10day3selenium;

import com.unitedcoder.dropdowns.CustomerType;
import com.unitedcoder.homework.week10day1class.Customer;
import com.unitedcoder.homework.week10day3constructor.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CCAddCustomerWithObject extends SetUpLogInLogOut{
    public  static void addCustomer(Customer customer){
        WebElement customerListLink = driver.findElement(By.xpath("//a[contains(text(),'Customer List')]"));
        customerListLink.click();
        WebElement addCustomerLink = driver.findElement(By.xpath("//a[contains(text(),'Add Customer')]"));
        addCustomerLink.click();
        WebElement status= driver.findElement(By.xpath("//img[@rel='#customer_status']"));
        if(!status.isEnabled()){
            status.click();
        }
        WebElement titleField = driver.findElement(By.xpath("//*[@id=\"cust-title\"]"));
        titleField.sendKeys(customer.getTitle());
        WebElement firstNameField = driver.findElement(By.xpath("//*[@id=\"cust-firstname\"]"));
        firstNameField.sendKeys(customer.getFirstName());
        WebElement lastNameField = driver.findElement(By.xpath("//*[@id=\"cust-lastname\"]"));
        lastNameField.sendKeys(customer.getLastName());

        WebElement customerType= driver.findElement(By.cssSelector("#cust-type"));
        Select select= new Select(customerType);
        select.selectByVisibleText(CustomerType.UNREGISTERED_CUSTOMER.getValue());

        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"cust-email\"]"));
        emailField.sendKeys(customer.getEmail());

        WebElement phoneField = driver.findElement(By.xpath("//*[@id=\"cust-phone\"]"));
        String abc =String.valueOf(customer.getPhone());
        phoneField.sendKeys(customer.getPhone());

        WebElement cellPhoneField=driver.findElement(By.id("cust-mobile"));
        cellPhoneField.sendKeys(customer.getCellPhone());

        WebElement newsLetter= driver.findElement(By.id("subscription_status"));
        Select newsletterStatues= new Select(newsLetter);
        newsletterStatues.selectByValue("1");

        WebElement saveButton = driver.findElement(By.xpath("//input[@name=\"save\"]"));
        saveButton.click();
    }

    //verify add customer successful
    public static boolean verifyCustomerAddedSuccessfully(){
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

class AddCustomerTestClass extends SetUpLogInLogOut{

    public static void main(String[] args) {
        driverSetUp("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        logIn(new User("testautomation2","automation123!"));

        Customer customer= new Customer("Miss","Sara"+System.currentTimeMillis(),
                "Watson"+System.currentTimeMillis(),"sara"+System.currentTimeMillis()+"@gmail.com",
                "2128435678","5436759886");

        CCAddCustomerWithObject method= new CCAddCustomerWithObject();
        CCAddCustomerWithObject.addCustomer(customer);
        CCAddCustomerWithObject.verifyCustomerAddedSuccessfully();

        SetUpLogInLogOut.logOut();
        SetUpLogInLogOut.tearDown();

    }
}
