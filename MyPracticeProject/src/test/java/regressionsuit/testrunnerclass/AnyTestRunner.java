package regressionsuit.testrunnerclass;

import com.unitedcoder.configutility.ApplicationConfig;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import regressionsuit.pageobjectmodel.DashboardPage;
import regressionsuit.pageobjectmodel.LoginPage;
import regressionsuit.pageobjectmodel.MailingListPage;
import regressionsuit.testngproject.DataBase;
import regressionsuit.testngproject.TestBaseForTestNG;
import regressionsuit.testngproject.TestResultListener;

@Listeners(TestResultListener.class)
public class AnyTestRunner extends TestBaseForTestNG {
    String userName= ApplicationConfig.readConfigProperties("config.properties","username");
    String password=ApplicationConfig.readConfigProperties("config.properties","password");
    DataBase testData;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    MailingListPage mailingListPage;
    @BeforeClass
    public void setUp(ITestContext context){
        openBrowser();
        loginPage=new LoginPage(driver);
        loginPage.login(userName,password);
        dashboardPage=new DashboardPage(driver);
        dashboardPage.verifyDashboardPage();
        testData=new DataBase();
        mailingListPage=new MailingListPage(driver);
        context.setAttribute("driver",driver);
    }
    @Test
    public void viewMailingListTest(){
        dashboardPage.clickOnMailingList();
        Assert.assertTrue(mailingListPage.viewMailingList());
    }
    @Test
    public void importSubscribers(){
        dashboardPage.clickOnMailingList();
        mailingListPage.importSubscribers(testData.emails());
        Assert.assertTrue(mailingListPage.verifyImportSubscribers());
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
