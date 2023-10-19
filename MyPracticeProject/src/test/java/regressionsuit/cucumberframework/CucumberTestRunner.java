package regressionsuit.cucumberframework;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author : user
 * @created : 16.10.2023,16:43
 * @Email :aliyeidiris@gmail.com
 **/
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-customer-ui-testReport.html"},
        features = {"classpath:features/"},
        tags = "@AddProduct"
)
public class CucumberTestRunner {

}
