package com.unitedcoder.selfproject;


import com.unitedcoder.cubecartautomation.CustomerInfo;
import com.unitedcoder.homework.week11cubecartproject.AdminUser;
import com.unitedcoder.homework.week11cubecartproject.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CubeCartTest extends BaseClass {
    public static void deleteMultipleCustomers() {
        WebElement customerListLink = driver.findElement(By.linkText("Customer List"));
        customerListLink.click();
        for (int i = 1; i <= 3; i++) {
            WebElement multiCustomerCheckBox = driver.findElement(By.xpath(String.format("//*[@id=\"customer-list\"]/table[2]/tbody/tr[%d]/td[1]/div", i)));
            multiCustomerCheckBox.click();
        }
        WebElement deleteIcon= driver.findElement(By.xpath("//*[@id=\"customer-list\"]/table[2]/tbody/tr[1]/td[8]/a[3]"));
        deleteIcon.click();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();
        WebElement verifyDeleteSuccess= driver.findElement(By.xpath("//div[contains(text(),\"successfully deleted.\")]"));
            if (verifyDeleteSuccess.isDisplayed()) {
                System.out.println("Some or all selected Customer successfully deleted.");
            }else{
            System.out.println("Delete not successful");
        }
    }


    public static void main(String[] args) {
        CustomerInfo customerInfo= new CustomerInfo("Sara1686729293213","Watson1686729293218",
                "Miss","sara1686729293218@gmail.com");
        openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        logIn(new AdminUser("testautomation2", "automation123!"));
        deleteMultipleCustomers();

        logOut();
        tearDown();
    }

}