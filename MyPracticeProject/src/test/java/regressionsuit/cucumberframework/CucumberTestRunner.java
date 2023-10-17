package regressionsuit.cucumberframework;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author : user
 * @created : 16.10.2023,16:43
 * @Email :aliyeidiris@gmail.com
 **/
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-product-ui-testReport.html"},
        features = {"classpath:features/customer.feature"},
        tags = "@CustomerFeature"
)
public class CucumberTestRunner {
    //static WebDriver driver;
/*    public static WebDriver getDriver(){
        return driver;
    }*/

 /*   @BeforeClass
    public static void setUp(){
        String url= ApplicationConfig.readConfigProperties("config.properties","qaurl");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    */
   /* @AfterClass
    public static void tearDown(){
        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.clickLogOut();
        closeBrowser();
    }*/

}
