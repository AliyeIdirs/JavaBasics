package regressionsuit.cucumberframework;

import com.unitedcoder.configutility.ApplicationConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import regressionsuit.junitframework.TestBase;

/**
 * @author : user
 * @created : 19.10.2023,14:54
 * @Email :aliyeidiris@gmail.com
 **/
public class Hooks extends TestBase {
    int headless= Integer.parseInt(ApplicationConfig.readConfigProperties("config.properties","headless"));
    @Before
    public void setUp(){
        if (headless==1){
            setUpBrowserInHeadlessMode();
        }else {
            openBrowser();
        }
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
