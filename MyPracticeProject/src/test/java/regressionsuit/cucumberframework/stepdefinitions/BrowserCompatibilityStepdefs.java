package regressionsuit.cucumberframework.stepdefinitions;

import com.unitedcoder.configutility.ApplicationConfig;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import regressionsuit.pageobjectmodel.DashboardPage;
import regressionsuit.pageobjectmodel.LoginPage;

/**
 * @author : user
 * @created : 20.10.2023,15:32
 * @Email :aliyeidiris@gmail.com
 **/
public class BrowserCompatibilityStepdefs {
    private Scenario scenario;
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    @Before
            public void beforeTest(Scenario scenario){
        this.scenario=scenario;
    }
    String siteUrl= ApplicationConfig.readConfigProperties("config.properties","qaurl");
    String username= ApplicationConfig.readConfigProperties("config.properties","username");
    String password=ApplicationConfig.readConfigProperties("config.properties","password");

    @Given("a valid username and password for login")
    public void aValidUsernameAndPasswordForLogin() {
        scenario.log("Username: "+username);
        scenario.log("Password: "+password);
    }

    @When("when the user enter username and password on the login page and clicks on the login button on the {string}")
    public void whenTheUserEnterUsernameAndPasswordOnTheLoginPageAndClicksOnTheLoginButtonOnThe(String browser) {
        if (browser.equalsIgnoreCase("safari")){
            WebDriverManager.safaridriver().setup();
            driver=new SafariDriver();
        }else if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.navigate().to(siteUrl);
        loginPage=new LoginPage(driver);
        loginPage.enterUerName(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("the user should see the admin dashboard page")
    public void theUserShouldSeeTheAdminDashboardPage() {
        dashboardPage=new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.verifyLogin());
    }
}


