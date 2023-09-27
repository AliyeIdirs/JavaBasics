package regressionsuit.databasetestautomation;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.cubecartobjects.CustomerObject;
import regressionsuit.pageobjectmodel.CustomerPage;
import regressionsuit.pageobjectmodel.DashboardPage;
import regressionsuit.pageobjectmodel.LoginPage;
import regressionsuit.testngproject.DataBase;
import regressionsuit.testngproject.TestBaseForTestNG;

import java.sql.Connection;

public class UIDBVerification extends TestBaseForTestNG {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    DataBase dataBase;
    CustomerObject customerObject;
    Connection connection;
    DataBaseConnection dataBaseConnection;
    SQLScripts SQLScripts;

    @BeforeClass
    public void setUp(){
        openBrowser();
        dataBase=new DataBase();
        loginPage=new LoginPage(driver);
        loginPage.login(dataBase.userName,dataBase.userPassword);
        dashboardPage=new DashboardPage(driver);
        customerPage=new CustomerPage(driver);
        customerObject=new CustomerObject(dataBase.firstName,dataBase.lastName,dataBase.email);
        dataBaseConnection=new DataBaseConnection();
        connection=dataBaseConnection.connectToDataBaseServer(dataBase.dbUrl, dataBase.dbPort, dataBase.dbUserName,
                dataBase.dbPassword, dataBase.defaultDB, ConnectionType.MYSQL);
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
    @AfterClass
    public void tearDown(){
        closeBrowser();
        dataBaseConnection.closeConnection(connection);
    }
}
