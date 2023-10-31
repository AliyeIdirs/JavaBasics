package regressionsuit.advancedactions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.testngproject.FunctionLibrary;

/**
 * @author : user
 * @created : 31.10.2023,13:35
 * @Email :aliyeidiris@gmail.com
 **/
public class JavaScriptTestRunner {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.twoplugs.com/");
        driver.manage().window().maximize();
        functionLibrary=new FunctionLibrary(driver);
    }
    @Test
    public void highlightElement(){
        functionLibrary.sleep(3);
        WebElement element=driver.findElement(By.xpath("/html/body/div/header/div/ul/li[2]/a"));
        functionLibrary.waitForElementPresent(element);
        JavaScriptMethods.highlightElement(element,driver);
    }
    @Test
    public void drawElement(){
        functionLibrary.sleep(2);
        WebElement element=driver.findElement(By.xpath("/html/body/div/header/div/ul/li[2]/a"));
        functionLibrary.waitForElementPresent(element);
        JavaScriptMethods.setElementBorder(element,driver);
    }
    @Test
    public void clickWithJS(){
        WebElement login=driver.findElement(By.xpath("//span[text()='LOG in'][1]"));
        JavaScriptMethods.clickWithJS(login,driver);
    }
    @Test
    public void sendKeysWithJS(){
        WebElement searchField=driver.findElement(By.name("q"));
        JavaScriptMethods.sendKeysWithJS(searchField,driver);
    }
    @Test
    public void getTitle(){
        JavaScriptMethods.getTitleWithJS(driver);
        JavaScriptMethods.generateAlert(driver,"Welcome to this site!!!");
        functionLibrary.sleep(5);
    }
    @Test
    public void scrollToElementVisible(){
        WebElement element=driver.findElement(By.linkText("ABOUT"));
        JavaScriptMethods.scrollToElementVisible(element,driver);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
