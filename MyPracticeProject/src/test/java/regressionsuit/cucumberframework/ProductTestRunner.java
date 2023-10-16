package regressionsuit.cucumberframework;

import com.unitedcoder.configutility.ApplicationConfig;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import regressionsuit.pageobjectmodel.DashboardPage;
import regressionsuit.pageobjectmodel.LoginPage;

/**
 * @author : user
 * @created : 16.10.2023,16:43
 * @Email :aliyeidiris@gmail.com
 **/
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-product-ui-testReport.html"},
        features = {"classpath:features/product-database.feature"}
)
public class ProductTestRunner {
    static WebDriver driver;
    public static WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public static void setUp(){
        String url= ApplicationConfig.readConfigProperties("config.properties","qaurl");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("testautomation1","automation123!");
    }

    @AfterClass
    public static void tearDown(){
        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.clickLogOut();
        driver.close();
        driver.quit();
    }

}
