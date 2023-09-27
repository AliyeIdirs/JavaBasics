package regressionsuit.week19project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerifyEmailLogPage {
    WebDriver driver;

    public VerifyEmailLogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindAll(
            @FindBy(xpath = "//i[@title='Resend']")
    )
    List<WebElement> resendIcons;
    public boolean verifyEmailLogPage(){
        return resendIcons.size()>=10;

    }
}
