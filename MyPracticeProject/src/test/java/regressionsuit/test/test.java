package regressionsuit.test;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

    public class test extends BaseClass {
        LoginPage loginPage;
        DashBoardPage dashBoardPag;
        ReviewPage reviewPage;

        MailingList mailingList;

        @BeforeClass
        public void setUp() {
            openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
            loginPage = new LoginPage(driver);
            loginPage.logIn("testautomation1", "automation123!");
            dashBoardPag = new DashBoardPage(driver);
            reviewPage=new ReviewPage(driver);
        }
        @Test
        public void ProductReview(){
            dashBoardPag.clickOnReviewLink();
            //reviewPage.addReview("c#");
        }
        @AfterClass
        public void tearDown(){
            closeBrowser();
        }

}
