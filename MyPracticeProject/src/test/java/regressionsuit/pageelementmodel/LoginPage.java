package regressionsuit.pageelementmodel;

import com.unitedcoder.configutility.ApplicationConfig;

/**
 * @author : user
 * @created : 16.10.2023,10:42
 * @Email :aliyeidiris@gmail.com
 **/
public class LoginPage extends BasePage{
    static String url= ApplicationConfig.readConfigProperties("config.properties","qaurl");
    public static void navigateToWebSite(){
        driver.get(url);
    }
    public static void enterUserName(String userName){
        PageUtility.WaitForElementVisible(LoginPageElement.userNameField);
        driver.findElement(LoginPageElement.userNameField).sendKeys(userName);
    }
    public static void enterPassword(String password){
        PageUtility.WaitForElementVisible(LoginPageElement.passwordField);
        driver.findElement(LoginPageElement.passwordField).sendKeys(password);
    }
    public static void clickLoinButton(){
        PageUtility.WaitForElementVisible(LoginPageElement.loginButton);
        driver.findElement(LoginPageElement.loginButton).click();
    }
}
