package regressionsuit.junitframework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import regressionsuit.pageobjectmodel.CategoryPage;
import regressionsuit.pageobjectmodel.CustomerPage;
import regressionsuit.pageobjectmodel.DashboardPage;
import regressionsuit.pageobjectmodel.LoginPage;

public class JunitTestRunner extends TestBase {
    static LoginPage loginPage;
    static DashboardPage dashboardPage;
    static CustomerPage customerPage;
    static CategoryPage categoryPage;

    @BeforeAll
    public static void setUp(){
        openBrowser();
        loginPage=new LoginPage(driver);
        dashboardPage=new DashboardPage(driver);
        customerPage=new CustomerPage(driver);
        categoryPage=new CategoryPage(driver);
        loginPage.login("testautomation1","automation123!");
        Assertions.assertTrue(dashboardPage.verifyLogin());
    }
    @Test
    public void addCustomerTest(){
        dashboardPage.clickCustomerList();
        customerPage.addCustomer();
        Assertions.assertTrue(customerPage.verifyAddCustomerSuccessfully());
    }
    @Test
    public void deleteCategory(){
        dashboardPage.clickCategories();
        categoryPage.deleteCategory();
        categoryPage.verifyCategoryDeleted();
    }
    @AfterAll
    public static void tearDown(){
        dashboardPage.clickLogOut();
        closeBrowser();
    }
}
