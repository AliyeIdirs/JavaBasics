package regressionsuit.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import regressionsuit.testngproject.FunctionLibrary;

public class LoginPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    int timeout=2;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }
    @FindBy(id="username")
    WebElement userNameField;
    @FindBy(id="password")
    WebElement passwordField;
    @FindBy(id="login")
    WebElement loginButton;

    public void enterUerName(String userName){
        userNameField.sendKeys(userName);
    }
    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public void login(String userName, String password){
        enterUerName(userName);
        enterPassword(password);
        clickLoginButton();

    }
    public void multiLoginTest(String username,String password){
        enterUerName(username);
        enterPassword(password);
        clickLoginButton();
        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.clickLogOut();
    }
}
