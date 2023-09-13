package regressionsuit.testngframework;

import com.unitedcoder.configutility.ApplicationConfig;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import regressionsuit.pageobjectmodel.CustomerPage;
import regressionsuit.pageobjectmodel.DashboardPage;
import regressionsuit.pageobjectmodel.LoginPage;
import regressionsuit.pageobjectmodel.ProductPage;
import regressionsuit.testngproject.TestBaseForTestNG;

@Listeners(TestResultListener.class)
public class TestNGRunner1 extends TestBaseForTestNG {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;
    CustomerPage customerPage;
    String userName= ApplicationConfig.readConfigProperties("config.properties","username");
    String password=ApplicationConfig.readConfigProperties("config.properties","password");
    @BeforeClass
    public void setUp(ITestContext context){
        openBrowser();
        loginPage=new LoginPage(driver);
        loginPage.login(userName,password);
        dashboardPage=new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.verifyDashboardPage());
        productPage=new ProductPage(driver);
        customerPage=new CustomerPage(driver);
        context.setAttribute("driver",driver);
    }
    @Test
    public void viewProduct(){
        dashboardPage.clickOnProductsLink();
        Assert.assertTrue(productPage.viewProductList());

    }
    @Test
    public void addCustomer(){
        dashboardPage.clickCustomerList();
        customerPage.addCustomer();
        Assert.assertTrue(customerPage.verifyAddCustomerSuccessfully());

    }
    @AfterClass
    public void tearDown(){
        dashboardPage.clickLogOut();
        closeBrowser();
    }
}
