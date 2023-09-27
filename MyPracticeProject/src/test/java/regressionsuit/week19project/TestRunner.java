package regressionsuit.week19project;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.pageobjectmodel.DashboardPage;
import regressionsuit.pageobjectmodel.LoginPage;
import regressionsuit.testngproject.DataBase;
import regressionsuit.testngproject.TestBaseForTestNG;

public class TestRunner extends TestBaseForTestNG {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    DataBase dataBase;
    @BeforeClass
    public void setUp(){
        openBrowser();
        dataBase=new DataBase();
        loginPage=new LoginPage(driver);
        loginPage.login(dataBase.userName, dataBase.userPassword);
        dashboardPage=new DashboardPage(driver);
    }
    @Test
    public void verifyCustomerListPage(){
       VerifyCustomerListPage verifyCustomerListPage =new VerifyCustomerListPage(driver);
       dashboardPage.clickCustomerList();
      Assert.assertTrue(verifyCustomerListPage.verifyCustomerListPage());
    }
    @Test
    public void verifyOrdersPage(){
        VerifyOrdersPage verifyOrdersPage=new VerifyOrdersPage(driver);
        dashboardPage.clickOnOrders();
        Assert.assertTrue(verifyOrdersPage.verifyOrdersPage());
    }
    @Test
    public void verifyProductsPage(){
        VerifyProductsPage verifyProductsPage=new VerifyProductsPage(driver);
        dashboardPage.clickOnProductsLink();
        Assert.assertTrue(verifyProductsPage.verifyProductPage());
    }
    @Test
    public void verifyEmailLog(){
        VerifyEmailLogPage emailLogPage=new VerifyEmailLogPage(driver);
        dashboardPage.clickOnEmailLogLink();
        Assert.assertTrue(emailLogPage.verifyEmailLogPage());
    }
    @AfterClass
    public void tearDown(){
        dashboardPage.clickLogOut();
        closeBrowser();
    }

}
