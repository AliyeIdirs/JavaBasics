package regressionsuit.databasetestautomation;

import com.unitedcoder.configutility.ApplicationConfig;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.testngproject.DataBase;

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
    DataBase dataBase;
    @BeforeClass
    public void establishConnection(){
        dataBaseConnection=new DataBaseConnection();
        connection=dataBaseConnection.connectToDataBaseServer(dbUrl,dbPort,dbUserName,dbPassword,standAloneDB,
                ConnectionType.MYSQL);
        SQLScripts =new SQLScripts();
        dataBase=new DataBase();
    }
    @Test(description = "Verify a product in the database")
    public void verifyProductTest(){
        boolean isProductExist= SQLScripts.getProductInfo("book",connection);
        Assert.assertTrue(isProductExist);
    }
    @Test
    public void verifyProductTest2(){
        Assert.assertTrue(SQLScripts.getProductInfo(connection,"book"));
    }
    @Test(description = "verify product exist in the database")
    public void verifyCustomerInfo(){
        Assert.assertTrue(SQLScripts.getCustomerInfo(connection,"Bilal","sss@hotmail.com"));
    }
    @Test(description = "insert record into category table")
    public void insertCategoryTable(){
        Category category=new Category("Cosmetics","Huda beauty"+dataBase.timeStamp(),
                1,0,0,0,0,0,dataBase.metaTitle,
                dataBase.metaDescription,1,1,0,"meta"+dataBase.timeStamp());
        Assert.assertTrue(SQLScripts.insertNewCategory(connection,category));
    }

    @AfterClass
    public void tearDown(){
        dataBaseConnection.closeConnection(connection);
    }
}
