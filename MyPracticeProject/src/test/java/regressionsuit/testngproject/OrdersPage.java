package regressionsuit.testngproject;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import regressionsuit.pageobjectmodel.FunctionLibrary;

import java.util.List;

public class OrdersPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    String customerEmail;
    String productName;
    public String orderNumber;

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
    @FindBy(xpath = "//a[@target='inventory-list']")
    WebElement productPlusSign;
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
    @FindBy(id = "subtotal")
    WebElement subTotalField;
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

    @FindBy(linkText = "Search Orders")
    WebElement searchOrderLink;
    @FindBy(name = "search[order_number]")
    WebElement orderNumberField;
    @FindBy(xpath = "//input[@value='Search']")
    WebElement searchButton;
    @FindAll(
            @FindBy(css = ".success")
    )
    List<WebElement> searchSuccessMessage;
    public void createOrder(String orderStatus,String customerEmail,String dispatchDate,String shippingMethod,String shippingDate,
                           List<String> trackingInfo,double weight,int quantity,String productName,String discountType,
                            double discountAmount,double shippingCost,double taxAmount,String internalNotes,String publicNotes) {
        createOrderLink.click();
        functionLibrary.waitForElementPresent(orderStatusField);
        Select selectStatus = new Select(orderStatusField);
        selectStatus.selectByVisibleText(orderStatus);
        functionLibrary.waitForElementPresent(billingLink);
        billingLink.click();
        findCustomerField.sendKeys(customerEmail);
        functionLibrary.sleep();
        WebElement targetCustomer = driver.findElement(By.xpath(String.format("//div[text()='%s']", customerEmail)));
        functionLibrary.waitForElementPresent(targetCustomer);
        targetCustomer.click();
        Select selectAddress = new Select(addressDropDown);
        selectAddress.selectByIndex(1);
        deliveryLink.click();
        copyFromBillingAddress.click();
        Select selectDeliveryAddress = new Select(deliveryPageAddressField);
        selectDeliveryAddress.selectByIndex(1);
        dispatchDateField.sendKeys(dispatchDate);
        shippingMethodField.sendKeys(shippingMethod);
        shippingProductField.sendKeys(shippingDate);
        deliveryTrackingField.sendKeys(trackingInfo.toString());
        weightField.sendKeys(String.valueOf(weight));
        functionLibrary.waitForElementPresent(inventoryLink);
        inventoryLink.click();
        functionLibrary.waitForElementPresent(quantityField);
        quantityField.sendKeys(String.valueOf(quantity));
        productNameField.sendKeys(productName);
        functionLibrary.sleep();
        driver.findElement(By.xpath(String.format("//span/em[text()='%s']", productName))).click();
        productPlusSign.click();
        Select selectDiscountType = new Select(discountDropDown);
        selectDiscountType.selectByVisibleText(discountType);
        discountInputField.sendKeys(String.valueOf(discountAmount));
        shippingField.sendKeys(String.valueOf(shippingCost));
        taxInputField.sendKeys(String.valueOf(taxAmount));
        taxPlusSign.click();
        switch (discountDropDown.getText()) {
            case "Fixed Price Discount":
                if (((Double.parseDouble(subTotalField.getText()) - discountAmount + shippingCost + taxAmount == Double.parseDouble(totalField.getText())))) {
                    notesLink.click();
                } else {
                    System.out.println("Total mismatch, please check amount");
                    break;
                }
            case "Percentage Discount":
                if (((Double.parseDouble(subTotalField.getText()) - (Double.parseDouble(subTotalField.getText()) * (discountAmount / 100)) + shippingCost + taxAmount == Double.parseDouble(totalField.getText())))) {
                    notesLink.click();
                } else {
                    System.out.println("Total mismatch, please check amount");
                    break;
                }
        }
        internalNotesField.sendKeys(internalNotes);
        publicNotesField.sendKeys(publicNotes);
        saveButton.click();
        DateTime now=new DateTime();
        DateTimeFormatter formatter= DateTimeFormat.forPattern("hh:mm");
        String orderCreateDate=now.toString(formatter);
        System.out.println(orderCreateDate);
        WebElement orderNumberField=driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]/ancestor::tr/td[2]",orderCreateDate)));
        orderNumber=orderNumberField.getText();
        System.out.println(orderNumber);
    }

    public boolean verifyCreateOrderSuccessful(){
        return verifyMessage.size()>=1;
    }

    public void searchOrder(String orderNumber){
        searchOrderLink.click();
        functionLibrary.waitForElementPresent(orderNumberField);
        orderNumberField.sendKeys(orderNumber);
        searchButton.click();
    }
    public boolean verifySearchOrder(){
        return searchSuccessMessage.size()>=1;
    }
}
