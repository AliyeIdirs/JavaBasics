package regressionsuit.testngproject;

import com.unitedcoder.configutility.ApplicationConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBaseForTestNG {
    public WebDriver driver;

    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get(ApplicationConfig.readConfigProperties("config.properties","qaurl"));
        driver.manage().window().maximize();
    }

    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
