package regressionsuit.testngframework;

import com.unitedcoder.configutility.ApplicationConfig;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import regressionsuit.pageobjectmodel.CustomerPage;
import regressionsuit.pageobjectmodel.DashboardPage;
import regressionsuit.pageobjectmodel.LoginPage;
import regressionsuit.pageobjectmodel.ProductPage;
import regressionsuit.testngproject.TestBaseForTestNG;
import regressionsuit.testngproject.TestResultListener;

@Listeners(TestResultListener.class)
public class TestNGRunner1 extends TestBaseForTestNG {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;
    CustomerPage customerPage;
    int headlessMode=Integer.parseInt(ApplicationConfig.readConfigProperties("config.properties","headless"));
    String userName= ApplicationConfig.readConfigProperties("config.properties","username");
    String password=ApplicationConfig.readConfigProperties("config.properties","password");
    @BeforeClass
    public void setUp(){
        if (headlessMode==1){
            setUpBrowserInHeadlessMode();
        }else {
            openBrowser();
        }
        loginPage=new LoginPage(driver);
        loginPage.login(userName,password);
        dashboardPage=new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.verifyLogin());
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
