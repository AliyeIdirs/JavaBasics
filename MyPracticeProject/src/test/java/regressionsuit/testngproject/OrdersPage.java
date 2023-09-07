package regressionsuit.testngproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import regressionsuit.pageobjectmodel.FunctionLibrary;

import java.util.List;

public class OrdersPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    public String customerName;
    String customerEmail;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }
    @FindBy(linkText = "Create Order")
    WebElement createOrderLink;
    @FindBy(id = "o_status")
    WebElement orderStatusField;
    @FindBy(xpath = "//img[@rel='#skip_email']")
    WebElement skipEmailCheckBox;
    @FindBy(linkText = "Billing")
    WebElement billingLink;
    @FindBy(id = "sum_name")
    WebElement findCustomerField;
    @FindBy(xpath = "//span/em[text()='Eric']/following-sibling::div[text()='1251692950180829@gmail.com']")
    WebElement targetCustomer;
    @FindBy(xpath = "//*[@class='address-list textbox' and @rel='sum']")
    WebElement addressDropDown;
    @FindBy(linkText = "Delivery")
    WebElement deliveryLink;
    @FindBy(id = "d_addresses")
    WebElement deliveryPageAddressField;
    @FindBy(xpath = "//a[@rel='billing']")
    WebElement copyFromBillingAddress;
    @FindBy(id = "sum_ship_date")
    WebElement dispatchDateField;
    @FindBy(id = "sum_ship_method")
    WebElement shippingMethodField;
    @FindBy(id = "sum_ship_product")
    WebElement shippingProductField;
    @FindBy(id = "sum_ship_tracking")
    WebElement deliveryTrackingField;
    @FindBy(id = "sum_weight")
    WebElement weightField;
    @FindBy(linkText = "Inventory")
    WebElement inventoryLink;
    @FindBy(xpath = "//tr[@class='update-subtotal inline-add']//*[@rel='product_quantity']")
    WebElement quantityField;
    @FindBy(id = "ajax_name")
    WebElement productNameField;
    @FindBy(xpath = "//span/em[text()='Coff']/following-sibling::div[contains(text(),'80')]")
    WebElement targetProduct;
    @FindBy(xpath = "//a[@target='inventory-list']")
    WebElement ProductPlusSign;
    @FindBy(id = "discount_type")
    WebElement discountDropDown;
    @FindBy(id = "discount")
    WebElement discountInputField;
    @FindBy(id = "shipping")
    WebElement shippingField;
    @FindBy(xpath = "//*[@rel='tax_id' and @class='not-empty tax-chooser']")
    WebElement selectTaxDropDown;
    @FindBy(css = ".textbox.number-right.tax.not-empty")
    WebElement taxInputField;
    @FindBy(id = "total_tax")
    WebElement totalTaxField;
    @FindBy(id = "total")
    WebElement totalField;
    @FindBy(xpath = "//a[@target='tax-list']")
    WebElement taxPlusSign;
    @FindBy(css = ".fa.fa-refresh")
    WebElement refreshIcon;
    @FindBy(linkText = "Notes")
    WebElement notesLink;
    @FindBy(name = "note")
    WebElement internalNotesField;
    @FindBy(name = "summary[note_to_customer]")
    WebElement publicNotesField;
    @FindBy(xpath = "//input[@value='Save']")
    WebElement saveButton;
    @FindAll(
            @FindBy(xpath = "//div[text()='Order successfully created.']")
    )
    List<WebElement> verifyMessage;

}
