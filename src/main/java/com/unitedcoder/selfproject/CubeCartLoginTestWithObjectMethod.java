package com.unitedcoder.selfproject;

import com.beust.ah.A;
import com.unitedcoder.homework.week11cubecartproject.AdminUser;
import com.unitedcoder.homework.week11cubecartproject.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.security.auth.login.FailedLoginException;
import java.sql.Array;
import java.util.*;

public class CubeCartLoginTestWithObjectMethod extends BaseClass {
    public static void logIn(AdminUser adminUser) {
        int chance = 3;
        while (chance >= 0) {
            WebElement userNameField = driver.findElement(By.id("username"));
            userNameField.sendKeys(adminUser.getUserName());
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys(adminUser.getPassword());
            WebElement loginButton = driver.findElement(By.id("login"));
            loginButton.click();
            try {
                if (!adminUser.getUserName().equalsIgnoreCase("testautomation2") ||
                        !adminUser.getPassword().equalsIgnoreCase("automation123!")) {
                    System.out.println("Invalid username or password");
                    throw new FailedLoginException();
                }
            } catch (FailedLoginException e) {
                e.getLocalizedMessage();
            }
            chance--;
            System.out.println("You have " + chance + " chance to login");
        }
        System.out.println("Your chance is used out.");
    }

    public static void main(String[] args) {
        openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php?");
        AdminUser adminUser1 = new AdminUser("testautomation1", "wrong password");
        AdminUser adminUser2 = new AdminUser("wrong username", "automation123!");
        AdminUser adminUser3 = new AdminUser("wrong username", "wrong password");
        AdminUser adminUser4 = new AdminUser("testautomation1", "automation123!");
            try{
                logIn(adminUser1);
                logIn(adminUser2);
                logIn(adminUser3);
                logIn(adminUser4);
            }catch(Exception e){
                e.printStackTrace();
            }


    }
}
