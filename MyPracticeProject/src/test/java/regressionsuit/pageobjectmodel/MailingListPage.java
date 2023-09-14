package regressionsuit.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import regressionsuit.testngproject.FunctionLibrary;

import java.util.List;

public class MailingListPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    public MailingListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }
    @FindAll(
            @FindBy(xpath = "//tbody/tr//input[@class='subscribers']")
    )
    List<WebElement> malingList;
    @FindBy(linkText = "Import Subscribers")
    WebElement importSubscribersLink;
    @FindBy(name = "subscribers")
    WebElement textArea;
    @FindBy(xpath = "//div[@class='form_control']//input[@value='Go']")
    WebElement goButton;
    @FindAll(
        @FindBy(xpath = "//div[contains(text(),'been added.')]")
    )
    List<WebElement> importSuccessMessage;
    @FindBy(linkText = "Export Subscribers")
    WebElement exportSubscribersLink;
    @FindBy(name = "maillist_extension")
    WebElement listExtensionField;
    @FindBy(id = "mailing_list_export")
    WebElement exportButton;
    public boolean viewMailingList(){
        functionLibrary.sleep(5);
        return malingList.size()>=1;
    }
    public void  importSubscribers(List<String> emails) {
        importSubscribersLink.click();
        for (int i = 0; i < emails.size(); i++) {
            String email = emails.get(i);
            textArea.sendKeys(email);
            textArea.sendKeys(",");
        }
        functionLibrary.waitForElementPresent(goButton);
        goButton.click();
    }
    public boolean verifyImportSubscribers() {
        functionLibrary.sleep(3);
           return importSuccessMessage.size()>=1;
    }
    public void exportSubscribers(){
        exportSubscribersLink.click();
        Select select=new Select(listExtensionField);
        select.selectByValue("txt");
        exportButton.click();
    }
}
