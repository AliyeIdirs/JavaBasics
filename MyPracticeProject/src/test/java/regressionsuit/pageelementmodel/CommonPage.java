package regressionsuit.pageelementmodel;

/**
 * @author : user
 * @created : 16.10.2023,11:10
 * @Email :aliyeidiris@gmail.com
 **/
public class CommonPage extends BasePage{
    public static void logOut(){
        PageUtility.WaitForElementVisible(CommonPageElement.logOutLink);
        driver.findElement(CommonPageElement.logOutLink).click();
    }
}
