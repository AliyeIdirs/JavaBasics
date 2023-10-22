package regressionsuit.databasetestautomation;

import com.unitedcoder.configutility.ApplicationConfig;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.testngproject.TestData;

import java.sql.Connection;

public class DBTestRunner {
    String fileName="config.properties";
    String dbUrl= ApplicationConfig.readConfigProperties(fileName,"dburl");
    String dbPort=ApplicationConfig.readConfigProperties(fileName,"dbport");
    String dbUserName=ApplicationConfig.readConfigProperties(fileName,"dbusername");
    String dbPassword=ApplicationConfig.readConfigProperties(fileName,"dbpassword");
    String defaultDB=ApplicationConfig.readConfigProperties(fileName,"dbname");
    String standAloneDB=ApplicationConfig.readConfigProperties(fileName,"standalonedbname");
    Connection connection;
    DataBaseConnection dataBaseConnection;
    SQLScripts SQLScripts;
    TestData testData;
    @BeforeClass
    public void establishConnection(){
        dataBaseConnection=new DataBaseConnection();
        connection=dataBaseConnection.connectToDataBaseServer(dbUrl,dbPort,dbUserName,dbPassword,standAloneDB,
                ConnectionType.MYSQL);
        SQLScripts =new SQLScripts();
        testData =new TestData();
    }
    @Test(description = "Verify a product in the database")
    public void verifyProductTest(){
        boolean isProductExist= SQLScripts.getProductInfo("book",connection);
        Assert.assertTrue(isProductExist);
    }
    @Test(description = "insert record into category table")
    public void insertCategoryTable(){
        Category category=new Category("Cosmetics","Huda beauty"+ testData.timeStamp(),
                1,0,0,0,0,0, testData.metaTitle,
                testData.metaDescription,1,1,0,"meta"+ testData.timeStamp());
        Assert.assertTrue(SQLScripts.insertNewCategory(connection,category));
    }

    @AfterClass
    public void tearDown(){
        dataBaseConnection.closeConnection(connection);
    }
}
