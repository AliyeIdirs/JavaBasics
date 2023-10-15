package regressionsuit.testrunnerclass;

import com.unitedcoder.configutility.ApplicationConfig;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import regressionsuit.cubecartobjects.NewsletterObject;
import regressionsuit.pageobjectmodel.DashboardPage;
import regressionsuit.pageobjectmodel.LoginPage;
import regressionsuit.pageobjectmodel.NewslettersPage;
import regressionsuit.testngproject.DataBase;
import regressionsuit.testngproject.TestBaseForTestNG;
import regressionsuit.testngproject.TestResultListener;

@Listeners(TestResultListener.class)
public class NewsletterTestRunner extends TestBaseForTestNG {
    String userName= ApplicationConfig.readConfigProperties("config.properties","username");
    String password=ApplicationConfig.readConfigProperties("config.properties","password");
    DataBase testData;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    NewslettersPage newslettersPage;
    NewsletterObject newsletterObject;
    @BeforeClass
    public void setUp(ITestContext context){
        testData=new DataBase();
        if (testData.headlessMode==1){
            setUpBrowserInHeadlessMode();
        }else{
            openBrowser();
        }
        loginPage=new LoginPage(driver);
        loginPage.login(userName,password);
        dashboardPage=new DashboardPage(driver);
        dashboardPage.verifyDashboardPage();
        newslettersPage=new NewslettersPage(driver);
        context.setAttribute("driver",driver);
    }
    @Test(dataProvider = "newsletterData")
    public void createNewsLetterTest(String newsLetterSubject,String senderName,String senderEmail,
                                     String htmlContent,String plainTextContent,String recipientEmail){
        newsletterObject=new NewsletterObject(newsLetterSubject,senderName,senderEmail,htmlContent,plainTextContent,
                recipientEmail);
        dashboardPage.clickOnNewsletters();
        newslettersPage.createNewsLetter(newsletterObject);
        Assert.assertTrue(newslettersPage.verifyNewsletterCreated());
    }
    @Test(dependsOnMethods = "createNewsLetterTest")
    public void editNewsletterTest(){
        dashboardPage.clickOnNewsletters();
        Assert.assertTrue(newslettersPage.editNewsletter(newsletterObject.getNewsLetterSubject()));
    }
    @Test(dependsOnMethods = "editNewsletterTest")
    public void deleteNewsletterTest(){
        dashboardPage.clickOnNewsletters();
        Assert.assertTrue(newslettersPage.deleteNewsletter(newsletterObject.getNewsLetterSubject()));
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }

    @DataProvider
    public Object[][] newsletterData() {
        return new Object[][]{
                {testData.newsLetterSubject, testData.senderName, testData.senderEmail, testData.htmlContent,
                        testData.plainTextContent, testData.recipientEmail}

        };
    }
}
