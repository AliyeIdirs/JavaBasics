package regressionsuit.databasetestautomation;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.cubecartobjects.CustomerObject;
import regressionsuit.pageobjectmodel.CustomerPage;
import regressionsuit.pageobjectmodel.DashboardPage;
import regressionsuit.pageobjectmodel.LoginPage;
import regressionsuit.testngproject.TestData;
import regressionsuit.testngproject.TestBaseForTestNG;

import java.sql.Connection;

public class UIDBVerification extends TestBaseForTestNG {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    TestData testData;
    CustomerObject customerObject;
    Connection connection;
    DataBaseConnection dataBaseConnection;
    SQLScripts SQLScripts;

    @BeforeClass
    public void setUp(){
        openBrowser();
        testData =new TestData();
        loginPage=new LoginPage(driver);
        loginPage.login(testData.userName, testData.userPassword);
        dashboardPage=new DashboardPage(driver);
        customerPage=new CustomerPage(driver);
        customerObject=new CustomerObject(testData.firstName, testData.lastName, testData.email);
        dataBaseConnection=new DataBaseConnection();
        connection=dataBaseConnection.connectToDataBaseServer(testData.dbUrl, testData.dbPort, testData.dbUserName,
                testData.dbPassword, testData.defaultDB, ConnectionType.MYSQL);
        SQLScripts =new SQLScripts();
    }
    @Test
    public void addCustomerUITest(){
        dashboardPage.clickCustomerList();
        customerPage.addCustomer(customerObject.getFirstName(),customerObject.getLastName(),customerObject.getEmail());
        Assert.assertTrue(customerPage.verifyAddCustomerSuccessfully());
    }
    @Test(dependsOnMethods = "addCustomerUITest")
    public void addCustomerDBTest(){
        Assert.assertTrue(SQLScripts.getCustomerInfo(connection,customerObject.getFirstName(),customerObject.getEmail()));
    }
    @Test(description = "verify product exist in the database")
    public void verifyCustomerInfo(){
        Assert.assertTrue(SQLScripts.getCustomerInfo(connection,"Bilal","sss@hotmail.com"));
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
        dataBaseConnection.closeConnection(connection);
    }
}
