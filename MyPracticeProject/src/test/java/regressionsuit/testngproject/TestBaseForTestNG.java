package regressionsuit.testngproject;

import com.unitedcoder.configutility.ApplicationConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;

public class TestBaseForTestNG {
    public WebDriver driver;

    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get(ApplicationConfig.readConfigProperties("config.properties","qaurl"));
        driver.manage().window().maximize();
    }
    public void setUpBrowserInHeadlessMode(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200,1100");
        options.addArguments("disable-gpu");
        driver=new ChromeDriver(options);
        driver.get(ApplicationConfig.readConfigProperties("config.properties","qaurl"));
        driver.manage().window().maximize();
    }
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
