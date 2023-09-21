package regressionsuit.advancedactions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdvancedActionsDemo3 {
    WebDriver driver;
    Actions actions;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();
        actions=new Actions(driver);
    }
    @Test
    public void clickTest(){
        //right click
        WebElement rightClickButton=driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickButton);
        Assert.assertTrue(driver.findElement(By.id("rightClickMessage")).isDisplayed(),
                "Element not found");
    }
    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
