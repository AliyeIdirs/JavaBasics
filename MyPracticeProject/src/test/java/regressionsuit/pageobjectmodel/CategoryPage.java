package regressionsuit.pageobjectmodel;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    int timeout=2;
    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }

    @FindBy(css = ".fa.fa-trash")
    WebElement deleteIcon;
    @FindBy(xpath = "//*[contains(text(),'deleted.')]")
    WebElement successMessage;

    public void deleteCategory(){
        functionLibrary.waitForElementPresent(deleteIcon);
        deleteIcon.click();
        Alert alert= driver.switchTo().alert();
        functionLibrary.waitAlertPresent();
        alert.accept();
    }
    public void verifyCategoryDeleted(){
        Assertions.assertTrue(successMessage.isDisplayed());
    }
}
