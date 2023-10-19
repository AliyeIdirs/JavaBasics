package regressionsuit.pageobjectmodel;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import regressionsuit.cubecartobjects.CustomerGroupObject;
import regressionsuit.cubecartobjects.CustomerObject;
import regressionsuit.testngproject.TestData;
import regressionsuit.testngproject.FunctionLibrary;

import java.util.*;

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
    @FindBy(id = "group_add_name")
    WebElement groupNameField;
    @FindBy(id = "group_add_description")
    WebElement groupDescriptionField;
    @FindBy(name = "save")
    WebElement groupSaveButton;
    @FindBy(xpath = "//div[contains(text(),'group added.')]")
    WebElement groupSuccessMessage;
    @FindBy(linkText = "Search Customers")
    WebElement searchCustomerTab;
    @FindBy(id = "customer_id")
    WebElement searchCustomerBar;
    @FindBy(xpath = "//*[@id=\"sidebar_content\"]/div[1]/form/input[3]")
    WebElement goButton;
    @FindBy(css = ".fa.fa-pencil-square-o")
    WebElement editIcon;
    @FindAll(
            @FindBy(xpath = "//div[text()='Customer successfully updated.']")
    )
    List<WebElement> updateSuccessMessage;

    public void addCustomerGroup(CustomerGroupObject customerGroupObject){
        customerGroupsLink.click();
        functionLibrary.waitForElementPresent(groupNameField);
        groupNameField.sendKeys(customerGroupObject.getGroupName());
        functionLibrary.waitForElementPresent(groupDescriptionField);
        groupDescriptionField.sendKeys(customerGroupObject.getGroupDescription());
        functionLibrary.waitForElementPresent(groupSaveButton);
        groupSaveButton.click();
        System.out.println("Customer Group Name: "+customerGroupObject.getGroupName());
    }
    public boolean verifyCustomerGroupAdded(){
        functionLibrary.waitForElementPresent(groupSuccessMessage);
        return groupSuccessMessage.isDisplayed();
    }
    public void selectCustomerType(){
        Select select=new Select(customerTypeDropDown);
        List<String> options=new ArrayList<>(Arrays.asList(TestData.customerType.REGISTERED_CUSTOMER.getValue(),
                TestData.customerType.UNREGISTERED_CUSTOMER.getValue()));
        Random random=new Random();
        String toBeSelected=options.get(random.nextInt(options.size()));
        select.selectByVisibleText(toBeSelected);
    }
    public void selectSubscriptionStatus(){
        Select select=new Select(subscriptionDropDown);
        List<String> selectOptions=new ArrayList<>(Arrays.asList(TestData.subscriptionStatus.NO.getValue(),
                TestData.subscriptionStatus.YES1.getValue(), TestData.subscriptionStatus.YES2.getValue()));
        Random random=new Random();
        String toBeSelected=selectOptions.get(random.nextInt(selectOptions.size()));
        select.selectByVisibleText(toBeSelected);
    }
    public void addCustomer(){
        functionLibrary.waitForElementPresent(addCustomerLink);
        addCustomerLink.click();
        functionLibrary.sleep();
        firstNameField.sendKeys(functionLibrary.generateFakeName(0));
        lastNameField.sendKeys(functionLibrary.generateFakeName(1));
        emailField.sendKeys(functionLibrary.generateFakeName(0)+"@hotmail.com");
        saveButton.click();
    }
    public void addCustomer(String firstName, String lastName, String email){
        functionLibrary.waitForElementPresent(addCustomerLink);
        addCustomerLink.click();
        functionLibrary.sleep();
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        saveButton.click();
    }
    public void addCustomerSimple(CustomerObject customerObject){
        functionLibrary.waitForElementPresent(addCustomerLink);
        addCustomerLink.click();
        functionLibrary.waitForElementPresent(statusField);
        statusField.click();
        firstNameField.sendKeys(customerObject.getFirstName());
        lastNameField.sendKeys(customerObject.getLastName());
        emailField.sendKeys(customerObject.getEmail());
        saveButton.click();
    }
    public void addCustomerDetailed(CustomerObject customerObject) {
        functionLibrary.waitForElementPresent(addCustomerLink);
        addCustomerLink.click();
        functionLibrary.waitForElementPresent(statusField);
        statusField.click();
        customerTitleField.sendKeys(customerObject.getTitle());
        firstNameField.sendKeys(customerObject.getFirstName());
        lastNameField.sendKeys(customerObject.getLastName());
        selectCustomerType();
        customerNotesField.sendKeys(customerObject.getCustomerNotes());
        emailField.sendKeys(customerObject.getEmail());
        phoneNumberField.sendKeys(customerObject.getPhone());
        cellphoneNumberField.sendKeys(customerObject.getCellPhone());
        selectSubscriptionStatus();
        try {
            passwordField.sendKeys(customerObject.getPassword());
            confirmPasswordField.sendKeys(customerObject.getConfirmPassword());
            if (!customerObject.getPassword().equalsIgnoreCase(customerObject.getConfirmPassword())) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException i) {
            System.out.println("password unmatched, please enter same passwords");
        } finally {
            addressLink.click();
        }
        addAddressLink.click();
        functionLibrary.waitForElementPresent(descriptionField);
        descriptionField.sendKeys(customerObject.getAddressDescription());
        addressTitleField.sendKeys(customerObject.getTitle());
        addressFirstNameField.sendKeys(customerObject.getFirstName());
        addressLastNameField.sendKeys(customerObject.getLastName());
        companyNameField.sendKeys(customerObject.getCompanyName());
        functionLibrary.sleep();
        if (customerObject.getAddress().length() > 35) {
            addressLine1.sendKeys(StringUtils.substring(customerObject.getAddress(), 0, 35));
            addressLine2.sendKeys(StringUtils.substring(customerObject.getAddress(), 35));
        } else {
            addressLine1.sendKeys(customerObject.getAddress());
        }
        townField.sendKeys(customerObject.getCity());
        Select selectCountry = new Select(countryField);
        selectCountry.selectByVisibleText(customerObject.getCountry());
        functionLibrary.sleep();
        if (stateField.getText().equalsIgnoreCase("-- None --")) {
            Select select = new Select(stateField);
            select.selectByIndex(1);
        } else {
            stateField.sendKeys(customerObject.getState());
        }
        zipCodeField.sendKeys(customerObject.getZipCode());
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
        selectCustomerGroup.selectByVisibleText(customerObject.getCustomerGroup());
        saveButton.click();
        System.out.println("Customer Name: " + customerObject.getFirstName());
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
        selectCustomerType();
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
        System.out.println("Customer Name: "+firstName);

    }
    public boolean verifyAddCustomerSuccessfully(){
        return successMessage.size()>=1;
    }
    public void updateCustomer(String customerEmail){
        functionLibrary.waitForElementPresent(searchCustomerTab);
        searchCustomerTab.click();
        functionLibrary.waitForElementPresent(searchCustomerTab);
        searchCustomerBar.click();
        searchCustomerBar.sendKeys(customerEmail);
        functionLibrary.sleep(3);
        goButton.click();
        functionLibrary.waitForElementPresent(editIcon);
        editIcon.click();
        customerNotesField.clear();
        customerNotesField.sendKeys("New customer note "+System.currentTimeMillis());
        saveButton.click();
    }
    public boolean verifyUpdateCustomer(){
        return updateSuccessMessage.size()>=1;
    }
}
