package regressionsuit.advancedactions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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
    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
