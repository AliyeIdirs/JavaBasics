package regressionsuit.testrunnerclass;

import com.unitedcoder.configutility.ApplicationConfig;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.pageobjectmodel.DashboardPage;
import regressionsuit.pageobjectmodel.FileManagerPage;
import regressionsuit.pageobjectmodel.LoginPage;
import regressionsuit.pageobjectmodel.MailingListPage;
import regressionsuit.testngproject.DataBase;
import regressionsuit.testngproject.TestBaseForTestNG;

public class AnyTestRunner extends TestBaseForTestNG {
    String userName= ApplicationConfig.readConfigProperties("config.properties","username");
    String password=ApplicationConfig.readConfigProperties("config.properties","password");
    DataBase testData;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    MailingListPage mailingListPage;
    FileManagerPage fileManagerPage;
    @BeforeClass
    public void setUp(ITestContext context){
        testData=new DataBase();
        if (testData.headlessMode==1){
            setUpBrowserInHeadlessMode();
        }else {
            openBrowser();
        }
        loginPage=new LoginPage(driver);
        loginPage.login(userName,password);
        dashboardPage=new DashboardPage(driver);
        dashboardPage.verifyDashboardPage();

        mailingListPage=new MailingListPage(driver);
        fileManagerPage=new FileManagerPage(driver);
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
    @Test
    public void uploadImageTest(){
        dashboardPage.clickOnImagesLink();
        String imagePath="/Users/user/Documents/Desktop Pics/image-from-rawpixel-id-3814725-jpeg.jpg";
        Assert.assertTrue(fileManagerPage.uploadImage(imagePath));

    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
