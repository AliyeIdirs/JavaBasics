package regressionsuit.pageelementmodel;

import com.unitedcoder.configutility.ApplicationConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author : user
 * @created : 16.10.2023,11:31
 * @Email :aliyeidiris@gmail.com
 **/
public class JunitTestRunner extends BasePage{
    @BeforeClass
    public static void testSetup() {
        TestResultGenerator.initializeHtmlTestResult();
        //load test config data
        int timeout = Integer.parseInt(ApplicationConfig.readConfigProperties("config.properties", "DocumentReadyTimeOut"));
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Before
    public void BeforeTestRun() {
        System.out.println("......Test Start.....");
    }
    @Test
    public void testLogin() {
        LoginPage.navigateToWebSite();
        LoginPage.enterUserName(ApplicationConfig.readConfigProperties("config.properties", "username"));
        LoginPage.enterPassword(ApplicationConfig.readConfigProperties("config.properties", "password"));
        LoginPage.clickLoinButton();
        PageUtility.WaitForElementVisible(CommonPageElement.logOutLink);
        try {
            Assert.assertTrue(driver.findElement(CommonPageElement.logOutLink).isDisplayed());
            TestResultGenerator.appendToHtmlTestResult("001", "Login Test", "User Login", "User should be logged in", "User Logged in", true, "login test");
        } catch (Exception e) {
            e.printStackTrace();
            TestResultGenerator.appendToHtmlTestResult("001", "Login Test", "User Login", "User should be logged in", "User Logged in", false, "login test");
        }
    }
    @After
    public void AfterTestRun() {
        System.out.println("... Test Complete..... ");
    }
    @AfterClass
    public static void logoutWriteReport() {
        CommonPage.logOut();
        TestResultGenerator.endHTMLTestResult();
        String finalResult = TestResultGenerator.getHtmlTestResultString();
        TestResultGenerator.writeToFile("Test", "LoginTest", ".html", finalResult);
        driver.close();
        driver.quit();
    }
}
