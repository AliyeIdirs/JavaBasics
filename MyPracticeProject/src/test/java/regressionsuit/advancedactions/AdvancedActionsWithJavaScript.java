package regressionsuit.advancedactions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdvancedActionsWithJavaScript {
    WebDriver driver;
    JavascriptExecutor jse;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://demo.mahara.org");
        driver.manage().window().maximize();
        jse=(JavascriptExecutor)driver;
    }
    @Test
    public void scrollTest(){
        jse.executeScript("window.scrollBy(0,300)","");
        jse.executeScript("window.scrollBy(0,700)","");
        WebElement legalLink=driver.findElement(By.linkText("Legal"));
        jse.executeScript("arguments[0].click();",legalLink);
        try {
            WebElement legalPageHeading=driver.findElement(By.cssSelector(".section-heading"));
            if (legalPageHeading.isDisplayed())
                System.out.println("Legal Statement page is displayed");
        }catch (NoSuchElementException e){
            System.out.println("No Such element present.");
        }
    }

    @Test
    public void jsClickTest(){
        driver.get("https://jqueryui.com/dialog/#animated");
        driver.switchTo().frame(0);
        WebElement openDialogButton=driver.findElement(By.id("opener"));
        System.out.println(openDialogButton.getLocation());
        jse.executeScript("arguments[0].click()",openDialogButton);
        WebElement basicDialogPopUp=driver.findElement(By.xpath("//span[text()='Basic dialog']"));
        Assert.assertTrue(basicDialogPopUp.isDisplayed());
    }
    @Test
    public void jsSendKeysTest(){
        driver.get("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        jse.executeScript("document.getElementById('username').value='testautomation1'");
        WebElement passwordField=driver.findElement(By.name("password"));
        jse.executeScript("arguments[0].value='automation123!';",passwordField);
        String passwordValue=passwordField.getAttribute("value");
        System.out.println(passwordValue);
        Assert.assertEquals(passwordValue,"automation123!");
        WebElement loginButton = driver.findElement(By.id("login"));
        jse.executeScript("arguments[0].click()",loginButton);
    }
    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
