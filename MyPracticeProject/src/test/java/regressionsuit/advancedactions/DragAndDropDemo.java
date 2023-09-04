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
import regressionsuit.pageobjectmodel.FunctionLibrary;

public class DragAndDropDemo {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        functionLibrary=new FunctionLibrary(driver);
    }
    @Test
    public void dragAndDropTest(){
        driver.get("https://jqueryui.com/droppable/");
        WebElement framePath=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(framePath);
        WebElement draggableElement=driver.findElement(By.id("draggable"));
        functionLibrary.waitForElementPresent(draggableElement);
        WebElement droppableElement=driver.findElement(By.id("droppable"));
        functionLibrary.waitForElementPresent(droppableElement);
        Actions actions=new Actions(driver);
        functionLibrary.sleep();
        //actions.dragAndDrop(draggableElement,droppableElement).build().perform();
        actions.clickAndHold(draggableElement).moveToElement(droppableElement).release().build().perform();
        Assert.assertTrue(droppableElement.getText().contains("Dropped!"));
    }
    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
