package regressionsuit.databasetestautomation;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;

public class DBTestRunner {
    Connection connection=null;
    String dbUrl="97.74.184.169";
    String dbusername="ucautomation2023";
    String dbpassword="testautomation123!";
    String dbport="3306";
    String dbname="i5751295_cc1";
    @BeforeClass
    public void establishConnection(){
        connection=DataBaseConnection.connectToDataBaseServer(dbUrl,dbport,dbname,dbusername,dbpassword,
                ConnectionType.MYSQL);
    }
    @Test(description = "Verify a product in the database")
    public void verifyProductTest(){
        DataAccess dataAccess=new DataAccess();
        boolean isProductExist=dataAccess.getProductInfo("smart watch",connection);
        Assert.assertTrue(isProductExist);
    }
    @AfterClass
    public void tearDown(){
        DataBaseConnection.closeDataBaseConnection(connection);
    }
}
