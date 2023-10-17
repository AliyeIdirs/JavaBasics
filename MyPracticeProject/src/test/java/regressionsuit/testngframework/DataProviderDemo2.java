package regressionsuit.testngframework;

import com.github.javafaker.Faker;
import com.unitedcoder.configutility.ApplicationConfig;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import regressionsuit.pageobjectmodel.CustomerPage;
import regressionsuit.pageobjectmodel.DashboardPage;
import regressionsuit.testngproject.FunctionLibrary;
import regressionsuit.pageobjectmodel.LoginPage;
import regressionsuit.testngproject.TestBaseForTestNG;

public class DataProviderDemo2 extends TestBaseForTestNG {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    FunctionLibrary functionLibrary;
    int headlessMode= Integer.parseInt(ApplicationConfig.readConfigProperties("config.properties","headless"));
    @BeforeClass
    public void setUp(){
        if (headlessMode==1){
            setUpBrowserInHeadlessMode();
        }else {
            openBrowser();
        }
        loginPage=new LoginPage(driver);
        dashboardPage=new DashboardPage(driver);
        customerPage=new CustomerPage(driver);
        functionLibrary=new FunctionLibrary(driver);
    }
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password){
        loginPage.login(username,password);
        Assert.assertTrue(dashboardPage.verifyLogin());
    }
    @Test(dataProvider = "customerData",dependsOnMethods = "loginTest",invocationCount = 3)
    public void addCustomerTest(String firstName,String lastName, String email){
        dashboardPage.clickCustomerList();
        customerPage.addCustomer(firstName,lastName,email);
        Assert.assertTrue(customerPage.verifyAddCustomerSuccessfully());

    }
    @AfterClass
    public void tearDown(){
        dashboardPage.clickLogOut();
        closeBrowser();
    }
    @DataProvider
    public Object[][] loginData(){
        Object[][] data=new Object[][]{
                {"testautomation1", "automation123!"}
        };
        return data;
    }
    @DataProvider
    public Object[][] customerData(){
        Object[][] data=new Object[][]{
                {functionLibrary.generateFakeName(0), functionLibrary.generateFakeName(1), Faker.instance().internet().emailAddress()}
        };
        return data;
    }
}
