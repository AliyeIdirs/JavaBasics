package regressionsuit.cucumberframework.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import regressionsuit.junitframework.TestBase;
import regressionsuit.pageobjectmodel.DashboardPage;
import regressionsuit.pageobjectmodel.LoginPage;
import regressionsuit.testngproject.DataBase;

/**
 * @author : user
 * @created : 17.10.2023,13:44
 * @Email :aliyeidiris@gmail.com
 **/
public class LoginStepdefs extends TestBase {
    DataBase db;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    @Given("CubeCart login page opened")
    public void cubecartLoginPageOpened() {
        openBrowser();
    }

    @When("user enter valid username and valid password")
    public void userEnterValidUsernameAndValidPassword() {
        db=new DataBase();
        loginPage=new LoginPage(driver);
        loginPage.login(db.userName,db.userPassword);
    }

    @Then("user login successfully")
    public void userLoginSuccessfully() {
        dashboardPage=new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.verifyLogin());
    }
}
