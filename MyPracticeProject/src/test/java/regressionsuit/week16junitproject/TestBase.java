package regressionsuit.week16junitproject;

import com.unitedcoder.configutility.ApplicationConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
    static WebDriver driver;
    static FunctionLibrary functionLibrary= new FunctionLibrary();
    public static void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver= new ChromeDriver(options);
        driver.get(ApplicationConfig.readConfigProperties("config.properties","qaurl"));
        driver.manage().window().maximize();
    }
    public static void login(String userName, String password){
        WebElement userNameField = driver.findElement(By.id("username"));
        FunctionLibrary.waitElementPresent(userNameField);
        userNameField.sendKeys(userName);
        WebElement passwordField = driver.findElement(By.id("password"));
        FunctionLibrary.waitElementPresent(passwordField);
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        functionLibrary.sleep();
        try {
            WebElement dashBoard = driver.findElement(By.xpath("//*[@id=\"dashboard\"]/h3"));
            FunctionLibrary.waitElementPresent(dashBoard);
            if (dashBoard.getText().equalsIgnoreCase("dashboard"))
                System.out.println("Login Successful");
        }
        catch(Exception e) {
            WebElement failMessage= driver.findElement(By.xpath("//li[contains(text(),\"Invalid username or password\")]"));
            if(failMessage.isDisplayed()){
                System.out.println("Invalid username or password");
            }
            System.out.println("Login failed.");
        }
    }

    public static void logOut(){
        WebElement logOutLink=driver.findElement(By.cssSelector(".fa.fa-sign-out"));
        FunctionLibrary.waitElementPresent(logOutLink);
        logOutLink.click();
    }

    public static void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
