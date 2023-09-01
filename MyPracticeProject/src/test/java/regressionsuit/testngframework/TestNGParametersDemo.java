package regressionsuit.testngframework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import regressionsuit.pageobjectmodel.DashboardPage;
import regressionsuit.pageobjectmodel.LoginPage;

public class TestNGParametersDemo {
    WebDriver driver;
    @Parameters({"url","username","password"})
    @Test
    public void loginTest(String url, String userName,String password){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.Login(userName,password);
    }
    @AfterClass
    public void closeBrowser(){
        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.clickLogOut();
        driver.close();
        driver.quit();
    }
}
