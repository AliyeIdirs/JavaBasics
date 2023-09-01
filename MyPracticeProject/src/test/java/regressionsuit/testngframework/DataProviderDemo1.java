package regressionsuit.testngframework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import regressionsuit.pageobjectmodel.LoginPage;

public class DataProviderDemo1 extends TestBaseForTestNG {
    LoginPage loginPage;
    @BeforeClass
    public void setUp(){
        openBrowser();
        loginPage=new LoginPage(driver);
    }
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password){
        loginPage.multiLoginTest(username,password);
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
    @DataProvider
    public Object[][] loginData(){
        Object[][] data=new Object[][]{
                {"testautomation1", "automation123!"},
                {"testautomation2","automation123!"}
        };
        return data;
    }
}
