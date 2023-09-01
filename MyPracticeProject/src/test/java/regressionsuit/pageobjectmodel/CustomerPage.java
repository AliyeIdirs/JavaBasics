package regressionsuit.pageobjectmodel;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }

    @FindBy(xpath = "//a[contains(text(),\"Add Customer\")]")
    WebElement addCustomerLink;
    @FindBy(name="customer[first_name]")
    WebElement firstNameField;
    @FindBy(id="cust-lastname")
    WebElement lastNameField;
    @FindBy(id="cust-email")
    WebElement emailField;
    @FindBy(name = "save")
    WebElement saveButton;
    @FindBy(css="div.success")
    WebElement successMessage;
    public void addCustomer(){
        functionLibrary.waitForElementPresent(addCustomerLink);
        addCustomerLink.click();
        functionLibrary.sleep();
        firstNameField.sendKeys(functionLibrary.generateFakeName(0));
        lastNameField.sendKeys(functionLibrary.generateFakeName(1));
        emailField.sendKeys(functionLibrary.generateFakeName(0)+"@hotmail.com");
        saveButton.click();
    }
    public void addCustomer(String firstName,String lastName,String email){
        functionLibrary.waitForElementPresent(addCustomerLink);
        addCustomerLink.click();
        functionLibrary.sleep();
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        saveButton.click();
    }
    public boolean verifyAddCustomerSuccessfully(){
        functionLibrary.waitForElementPresent(successMessage);
        return successMessage.isDisplayed();
    }

}
