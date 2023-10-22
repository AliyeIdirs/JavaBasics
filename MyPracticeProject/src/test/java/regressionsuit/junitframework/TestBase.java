package regressionsuit.junitframework;

import com.unitedcoder.configutility.ApplicationConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
    public static WebDriver driver;
    static String url= ApplicationConfig.readConfigProperties("config.properties","qaurl");
    public static void setUpBrowserInHeadlessMode(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200,1100");
        options.addArguments("disable-gpu");
        driver=new ChromeDriver(options);
        driver.get(url);
        driver.manage().window().maximize();
    }
    public static void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }
    public static void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
