package regressionsuit.advancedactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.testngproject.TestBaseForTestNG;

public class AdvancedActionsDemo2 extends TestBaseForTestNG {
    Actions actions;
    @BeforeClass
    public void setUp(){
        openBrowser();
        actions=new Actions(driver);

    }
    @Test
    public void loginTest1(){
        WebElement usernameField=driver.findElement(By.id("username"));
        WebElement passwordField=driver.findElement(By.id("password"));
        WebElement loginButton=driver.findElement(By.id("login"));
        //login with actions
        actions.moveToElement(usernameField).click().sendKeys("testautomation1")
                .moveToElement(passwordField).click().sendKeys("automation123!")
                .moveToElement(loginButton).click().build().perform();

    }
    @Test
    public void loginTest2(){
        WebElement usernameField=driver.findElement(By.id("username"));
        WebElement passwordField=driver.findElement(By.id("password"));
        WebElement loginButton=driver.findElement(By.id("login"));
        actions.sendKeys(usernameField,"testautomaiton1")
                .sendKeys(passwordField,"automaiton123!")
                .click(loginButton).build().perform();
    }
    @Test
    public void enterUpperCase(){
        WebElement usernameField=driver.findElement(By.id("username"));
        actions.keyDown(Keys.SHIFT).sendKeys(usernameField,"test")
                .keyUp(Keys.SHIFT).sendKeys("automation1")
                .build().perform();
    }
    @Test
    public void copyPasteTest(){
        WebElement usernameField=driver.findElement(By.id("username"));
        actions.keyDown(Keys.SHIFT).sendKeys(usernameField,"test")
                .keyUp(Keys.SHIFT).sendKeys("automation1")
                .build().perform();
        WebElement passwordField=driver.findElement(By.id("password"));
        actions.keyDown(Keys.COMMAND).sendKeys("ac") //select all and copy
                .keyUp(Keys.COMMAND).click(passwordField)
                .keyDown(Keys.COMMAND).sendKeys("v") //paste
                .keyUp(Keys.COMMAND).build().perform();
        System.out.println(passwordField.getAttribute("value"));
    }
    @Test(dependsOnMethods = "loginTest1")
    public void scrollToElement(){
        driver.findElement(By.linkText("Customer List")).click();
        Select select=new Select(driver.findElement(By.className("select_url")));
        select.selectByVisibleText("100 Items");
        WebElement customerEmail=driver.findElement(
                By.xpath("//td[text()='scottie.schaden@yahoo.com']"));
        actions.scrollToElement(customerEmail).
                moveToElement(customerEmail).doubleClick().perform();
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
