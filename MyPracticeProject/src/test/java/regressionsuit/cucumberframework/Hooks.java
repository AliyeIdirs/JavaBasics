package regressionsuit.cucumberframework;

import com.unitedcoder.configutility.ApplicationConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import regressionsuit.junitframework.TestBase;
import regressionsuit.pageobjectmodel.DashboardPage;

/**
 * @author : user
 * @created : 19.10.2023,14:54
 * @Email :aliyeidiris@gmail.com
 **/
public class Hooks extends TestBase {
    int headless= Integer.parseInt(ApplicationConfig.readConfigProperties("config.properties","headless"));
    @Before
    public void setUp(Scenario scenario){
        if (scenario.getSourceTagNames().contains("@UITest")){
            scenario.log("UI test started...");
            if (headless==1){
                setUpBrowserInHeadlessMode();
            }else {
                openBrowser();
            }
        } else  if (scenario.getSourceTagNames().contains("@DatabaseTest")){
            scenario.log("Database test started...");
        }else if(scenario.getSourceTagNames().contains("@ApiTest")){
            scenario.log("Api test started");
        }
    }
   @After("@UITest")
    public void tearDownBrowser(Scenario scenario) {
       scenario.log("UI test ended!");
       DashboardPage dashboardPage = new DashboardPage(driver);
       dashboardPage.clickLogOut();
       closeBrowser();
   }
   @After("@DatabaseTest")
    public void tearDownDatabase(Scenario scenario) {
       scenario.log("Database test ended!");
   }

   @After("@ApiTest")
    public void tearDownApi(Scenario scenario){
            scenario.log("Api test ended!");
    }
}
