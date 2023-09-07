package regressionsuit.testngframework;

import com.unitedcoder.configutility.ApplicationConfig;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.pageobjectmodel.CustomerPage;
import regressionsuit.pageobjectmodel.DashboardPage;
import regressionsuit.pageobjectmodel.LoginPage;
import regressionsuit.pageobjectmodel.ProductPage;

public class TestNGRunner2 extends TestBaseForTestNG{
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;
    CustomerPage customerPage;
    String userName= ApplicationConfig.readConfigProperties("config.properties","username");
    String password=ApplicationConfig.readConfigProperties("config.properties","password");
    @BeforeClass
    public void setUp(ITestContext iTestContext){
        openBrowser();
        loginPage=new LoginPage(driver);
        loginPage.login(userName,password);
        dashboardPage=new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.verifyDashboardPage());
        productPage=new ProductPage(driver);
        customerPage=new CustomerPage(driver);
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
