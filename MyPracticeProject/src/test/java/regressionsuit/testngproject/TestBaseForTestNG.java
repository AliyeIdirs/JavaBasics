package regressionsuit.testngproject;

import com.unitedcoder.configutility.ApplicationConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBaseForTestNG {
    public WebDriver driver;
    String url=ApplicationConfig.readConfigProperties("config.properties","qaurl");

    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
    public void setUpBrowserInHeadlessMode(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200,1100");
        options.addArguments("disable-gpu");
        driver=new ChromeDriver(options);
        driver.get(url);
        driver.manage().window().maximize();
    }
    public void setUpBrowserWithHeadlessMode1(){
        System.setProperty("webdriver.http.factory","jdk-http-client");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        if (SystemUtils.IS_OS_LINUX) {
            options.addArguments("headless");
            options.addArguments("window-size=1200,1100");
            options.addArguments("disable-gpu");
        }
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        if (SystemUtils.IS_OS_MAC_OSX||SystemUtils.IS_OS_WINDOWS){
            driver.manage().window().maximize();
        }
        driver.get(url);

    }
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
