package regressionsuit.databasetestautomation;

import com.unitedcoder.configutility.ApplicationConfig;
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
    int headless= Integer.parseInt(ApplicationConfig.readConfigProperties("config.properties","headless"));

    @BeforeClass
    public void setUp(){
        if (headless==1){
            setUpBrowserInHeadlessMode();
        }else {
            openBrowser();
        }
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
    public void CustomerInfoDBVerificationTest(){
        Assert.assertTrue(SQLScripts.getCustomerInfo(connection,customerObject.getFirstName(),customerObject.getEmail()));
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
        dataBaseConnection.closeConnection(connection);
    }
}
