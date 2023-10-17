package regressionsuit.httpclientapi.dolkunteacherscode;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import regressionsuit.pageelementmodel.PageUtility;

/**
 * @author : user
 * @created : 17.10.2023,11:03
 * @Email :aliyeidiris@gmail.com
 **/
public class TestApiWithUi {
    private static int timeout = 30;
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://api.openweathermap.org/data/2.5/weather?q=Baltimore,us&AppID=70926ddfd37fdf454548b8db13695995");
    }

    @Test
    public void testWeatherAPIWithUI() throws InterruptedException {
        PageUtility.WaitForElementVisible(By.tagName("pre"));
        WebElement preTagElement = driver.findElement(By.tagName("pre"));
        String responseText = preTagElement.getText();
        System.out.println(responseText);
        JSONParser parser = new JSONParser();
        JSONObject jsonUi = null;
        try {
            jsonUi = (JSONObject) parser.parse(responseText);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Thread.sleep(2000);
        JSONObject apiResponseJson = ApiCall.getWeatherDataByCityName("Baltimore", "us");
        System.out.println(apiResponseJson);
        Assert.assertEquals(jsonUi.keySet(), apiResponseJson.keySet());

    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();

    }
}
