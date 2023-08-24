package regressionsuit.pageobjectmodel;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        functionLibrary.explicitWait(userNameField);
        userNameField.sendKeys(userName);
    }
    public void enterPassword(String password){
        functionLibrary.explicitWait(passwordField);
        passwordField.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public void Login(String userName,String password){
        enterUerName(userName);
        enterPassword(password);
        clickLoginButton();
    }
}
