package regressionsuit.cucumberframework;

import regressionsuit.junitframework.TestBase;

/**
 * @author : user
 * @created : 19.10.2023,14:54
 * @Email :aliyeidiris@gmail.com
 **/
public class Hooks extends TestBase {
 /*   int headless= Integer.parseInt(ApplicationConfig.readConfigProperties("config.properties","headless"));
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
    @After
    public void tearDown(Scenario scenario){
        if (scenario.getSourceTagNames().contains("UITest")) {
            scenario.log("UI test ended!");
            closeBrowser();
        }else if (scenario.getSourceTagNames().contains("@DatabaseTest")){
            scenario.log("Database test ended!");
        } else if (scenario.getSourceTagNames().contains("@ApiTest")) {
            scenario.log("Api test ended!");
        }
    }*/
}
