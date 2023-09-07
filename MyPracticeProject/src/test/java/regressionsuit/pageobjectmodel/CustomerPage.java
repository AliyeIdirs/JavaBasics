package regressionsuit.pageobjectmodel;

import com.unitedcoder.homework.week11cubecartproject.CustomerObject;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import regressionsuit.testngproject.TestData;

import java.util.InputMismatchException;
import java.util.List;

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
    @FindBy(xpath ="//img[@rel='#customer_status']" )
    WebElement statusField;
    @FindBy(id="cust-title")
    WebElement customerTitleField;
    @FindBy(name="customer[first_name]")
    WebElement firstNameField;
    @FindBy(id="cust-lastname")
    WebElement lastNameField;
    @FindBy(id = "cust-type")
    WebElement customerTypeDropDown;
    @FindBy(id = "cust-notes")
    WebElement customerNotesField;
    @FindBy(id="cust-email")
    WebElement emailField;
    @FindBy(id = "cust-phone")
    WebElement phoneNumberField;
    @FindBy(id = "cust-mobile")
    WebElement cellphoneNumberField;
    @FindBy(id = "subscription_status")
    WebElement subscriptionDropDown;
    @FindBy(id = "cust-password")
    WebElement passwordField;
    @FindBy(id = "cust-passconf")
    WebElement confirmPasswordField;
    @FindBy(linkText = "Addresses")
    WebElement addressLink;
    @FindBy(css = ".colorbox.address-form.cboxElement")
    WebElement addAddressLink;
    @FindBy(id = "edit_description")
    WebElement descriptionField;
    @FindBy(id = "edit_title")
    WebElement addressTitleField;
    @FindBy(name = "address[first_name][]")
    WebElement addressFirstNameField;
    @FindBy(id = "edit_last_name")
    WebElement addressLastNameField;
    @FindBy(id = "edit_company_name")
    WebElement companyNameField;
    @FindBy(name = "address[line1][]")
    WebElement addressLine1;
    @FindBy(name = "address[line2][]")
    WebElement addressLine2;
    @FindBy(id = "edit_town")
    WebElement townField;
    @FindBy(id = "edit_country")
    WebElement countryField;
    @FindBy(name = "address[state][]")
    WebElement stateField;
    @FindBy(id = "edit_postcode")
    WebElement zipCodeField;
    @FindBy(name = "address[billing][]")
    WebElement billingAddressCheckBox;
    @FindBy(name = "address[default][]")
    WebElement deliveryAddressCheckBox;
    @FindBy(xpath = "//input[@target='address-list']")
    WebElement addButton;
    @FindBy(linkText = "Customer Groups")
    WebElement customerGroupsLink;
    @FindBy(id = "group-join")
    WebElement customerGroupSelectField;
    @FindBy(name = "save")
    WebElement saveButton;
    @FindAll(
            @FindBy(css="div.success"))
    List<WebElement> successMessage;
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

    public void addCustomer(String title, String firstName, String lastName, String customerNotes, String email, String phone, String cellPhone,
                            String password, String confirmPassword, String addressDescription, String companyName, String address, String city,
                            String country, String state, String zipCode, String customerGroup){
        functionLibrary.waitForElementPresent(addCustomerLink);
        addCustomerLink.click();
        functionLibrary.waitForElementPresent(statusField);
        statusField.click();
        customerTitleField.sendKeys(title);
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        Select selectType = new Select(customerTypeDropDown);
        selectType.selectByVisibleText(TestData.customerType.REGISTERED_CUSTOMER.getValue());
        customerNotesField.sendKeys(customerNotes);
        emailField.sendKeys(email);
        phoneNumberField.sendKeys(phone);
        cellphoneNumberField.sendKeys(cellPhone);
        Select selectSubscription=new Select(subscriptionDropDown);
        selectSubscription.selectByVisibleText(TestData.subscriptionStatus.YES1.getValue());
        try {
            passwordField.sendKeys(password);
            confirmPasswordField.sendKeys(confirmPassword);
            if (!password.equalsIgnoreCase(confirmPassword)){
                throw new InputMismatchException();
            }
        }catch(InputMismatchException i) {
            System.out.println("password unmatched, please enter same passwords");
        }finally {
            addressLink.click();
        }
        addAddressLink.click();
        functionLibrary.waitForElementPresent(descriptionField);
        descriptionField.sendKeys(addressDescription);
        addressTitleField.sendKeys(title);
        addressFirstNameField.sendKeys(firstName);
        addressLastNameField.sendKeys(lastName);
        companyNameField.sendKeys(companyName);
        functionLibrary.sleep();
        if (address.length() > 35) {
            addressLine1.sendKeys(StringUtils.substring(address, 0, 35));
            addressLine2.sendKeys(StringUtils.substring(address, 35));
        } else {
            addressLine1.sendKeys(address);
        }
        townField.sendKeys(city);
        Select selectCountry = new Select(countryField);
        selectCountry.selectByVisibleText(country);
        functionLibrary.sleep();
        if(stateField.getText().equalsIgnoreCase("-- None --")){
            Select select = new Select(stateField);
            select.selectByIndex(1);
        }else {
            stateField.sendKeys(state);
        }
        zipCodeField.sendKeys(zipCode);
        if (!billingAddressCheckBox.isEnabled()) {
            billingAddressCheckBox.click();
        }
        if (!deliveryAddressCheckBox.isEnabled()) {
            deliveryAddressCheckBox.click();
        }
        addButton.click();
        functionLibrary.waitForElementPresent(customerGroupsLink);
        customerGroupsLink.click();
        functionLibrary.waitForElementPresent(customerGroupSelectField);
        Select selectCustomerGroup = new Select(customerGroupSelectField);
        selectCustomerGroup.selectByVisibleText(customerGroup);
        saveButton.click();
    }
    public boolean verifyAddCustomerSuccessfully(){
        return successMessage.size()>=1;
    }
}
