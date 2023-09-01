package regressionsuit.testngframework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBaseForTestNG {
    WebDriver driver;
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        driver.navigate().to("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        driver.manage().window().maximize();
    }

    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
