package regressionsuit.cucumberframework.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import regressionsuit.cubecartobjects.CustomerObject;
import regressionsuit.junitframework.TestBase;
import regressionsuit.pageobjectmodel.CustomerPage;
import regressionsuit.pageobjectmodel.DashboardPage;
import regressionsuit.pageobjectmodel.LoginPage;
import regressionsuit.testngproject.DataBase;

/**
 * @author : user
 * @created : 17.10.2023,12:16
 * @Email :aliyeidiris@gmail.com
 **/
public class CustomerUIStepdefs extends TestBase {
    //WebDriver driver;//= CucumberTestRunner.getDriver();
    DataBase db;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    CustomerObject customerObject;
    String email="emailho3336666@hotmail.com";
    @Given("user is on the customer list page")
    public void userIsOnTheCustomerListPage() {
        db=new DataBase();
        openBrowser();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(db.userName,db.userPassword);
        dashboardPage=new DashboardPage(driver);
        customerPage=new CustomerPage(driver);
        dashboardPage.clickCustomerList();
    }

    @When("user fills customer info")
    public void userFillsCustomerInfo() {
        customerObject=new CustomerObject(db.firstName,db.lastName, email);
        customerPage.addCustomerSimple(customerObject);
        //System.out.println(customerObject.getEmail());
    }

    @Then("new customer should be created")
    public void newCustomerShouldBeCreated() {
        Assert.assertTrue(customerPage.verifyAddCustomerSuccessfully());
    }
    @When("user update the customer info")
    public void userUpdateTheCustomerInfo() {
        customerPage.updateCustomer(email);
        //System.out.println(customerObject.getEmail());
    }

    @Then("user verify the customer info is updated")
    public void userVerifyTheCustomerInfoIsUpdated() {
        customerPage.verifyUpdateCustomer();
    }

}
