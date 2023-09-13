package regressionsuit.testngproject;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import regressionsuit.pageobjectmodel.FunctionLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OrdersPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    public String orderNumber;
    Actions actions;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
        actions=new Actions(driver);
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
    @FindBy(id = "ui-datepicker-div")
    WebElement calendar;
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
    @FindBy(id ="search_customer_id")
    WebElement customerNameField;
    @FindBy(xpath = "//input[@value='Search']")
    WebElement searchButton;
    @FindAll(
            @FindBy(css = ".success")
    )
    List<WebElement> searchSuccessMessage;
    @FindAll(
            @FindBy(xpath = "//tbody/tr")
    )
    List<WebElement> ordersList;
    @FindBy(xpath = "//a[text()='GDPR Tools']")
    WebElement gdprToolsLink;
    @FindBy(css = ".number-center")
    WebElement monthInputField;
    @FindBy(css = ".delete.submit_confirm.tiny")
    WebElement goButton;

    public void selectOrderStatus(){
        functionLibrary.waitForElementPresent(orderStatusField);
        Select selectStatus = new Select(orderStatusField);
        List<String> options=new ArrayList<>(Arrays.asList(DataBase.orderStatus.ORDER_COMPLETE.getValue(),
                DataBase.orderStatus.PROCESSING.getValue(),DataBase.orderStatus.DECLINED.getValue(),
                DataBase.orderStatus.PENDING.getValue(),DataBase.orderStatus.CANCELLED.getValue(),
                DataBase.orderStatus.FAILED_FRAUD_REVIEW.getValue()));
        Random random=new Random();
        String tobeSelected=options.get(random.nextInt(options.size()));
        selectStatus.selectByVisibleText(tobeSelected);
    }
    public void selectDiscountType(){
        functionLibrary.waitForElementPresent(discountDropDown);
        Select select = new Select(discountDropDown);
        List<String> options=new ArrayList<>(Arrays.asList(DataBase.discountType.FIXED_PRICE_DISCOUNT.getValue(),
                DataBase.discountType.PERCENTAGE_DISCOUNT.getValue()));
        Random random=new Random();
        String tobeSelected=options.get(random.nextInt(options.size()));
        select.selectByVisibleText(tobeSelected);
    }
    public void enterDispatchDate(int year,int month, int day){
        functionLibrary.waitForElementPresent(dispatchDateField);
        dispatchDateField.click();
        while(true){
            WebElement yearField=driver.findElement(By.className("ui-datepicker-year"));
            String currentYear=yearField.getText();
            if(Integer.parseInt(currentYear)<year) {
                WebElement nextButton = driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e"));
                nextButton.click();
            }else if(Integer.parseInt(currentYear)>year){
                WebElement prevButton=driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-w"));
                prevButton.click();
            }else{
                break;
            }
        }
        functionLibrary.sleep();
        WebElement monthField=driver.findElement(By.className("ui-datepicker-month"));
        Select selectMonth=new Select(monthField);
        selectMonth.selectByValue(String.valueOf(month-1));
        WebElement dayField=driver.findElement(By.xpath(String.format("//a[text()='%s']",(day))));
        dayField.click();
    }
    public void createOrder(String customerEmail,String dispatchDate,String shippingMethod,String shippingDate,
                           List<String> trackingInfo,double weight,int quantity,String productName,
                            double discountAmount,double shippingCost,double taxAmount,String internalNotes,String publicNotes) {
        createOrderLink.click();
        selectOrderStatus();
        functionLibrary.waitForElementPresent(billingLink);
        billingLink.click();
        findCustomerField.sendKeys(customerEmail);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement targetCustomer = driver.findElement(By.xpath(String.format("//div[text()='%s']", customerEmail)));
        functionLibrary.waitForElementPresent(targetCustomer);
        actions.moveToElement(targetCustomer).click().build().perform();
        functionLibrary.waitForElementPresent(addressDropDown);
        Select selectAddress = new Select(addressDropDown);
        selectAddress.selectByIndex(1);
        deliveryLink.click();
        copyFromBillingAddress.click();
        Select selectDeliveryAddress = new Select(deliveryPageAddressField);
        selectDeliveryAddress.selectByIndex(1);
        String dispatchDateValue[]=dispatchDate.split("-");
        enterDispatchDate(Integer.parseInt(dispatchDateValue[0]),Integer.parseInt(dispatchDateValue[1]),Integer.parseInt(dispatchDateValue[2]));
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
        selectDiscountType();
        discountInputField.sendKeys(String.valueOf(discountAmount));
        shippingField.sendKeys(String.valueOf(shippingCost));
        taxInputField.sendKeys(String.valueOf(taxAmount));
        taxPlusSign.click();
        notesLink.click();
        internalNotesField.sendKeys(internalNotes);
        publicNotesField.sendKeys(publicNotes);
        saveButton.click();
        DateTime now=new DateTime();
        DateTimeFormatter formatter= DateTimeFormat.forPattern("HH:mm");
        DateTimeZone utcTimeZone= DateTimeZone.forID("UTC");
        DateTime utcTime=new DateTime(now.withZone(utcTimeZone));
        String orderCreationTime=utcTime.toString(formatter);
        WebElement orderNumberField=driver.findElement(By.xpath(String.format("//td[contains(text(),'Today, %s')]/ancestor::tr/td[2]",orderCreationTime)));
        orderNumber=orderNumberField.getText();
        System.out.println("Order number is: "+orderNumber);
    }

    public boolean verifyCreateOrderSuccessful(){
        return verifyMessage.size()>=1;
    }

    public void searchOrder(){
        searchOrderLink.click();
        functionLibrary.sleep(3);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].value='"+orderNumber+"';",orderNumberField);
        functionLibrary.sleep(1);
        actions.click(searchButton).perform();
    }
    public boolean verifySearchOrder(){
        if(searchSuccessMessage.size()>=1){
            System.out.println("Order number: "+orderNumber+" searched successfully");
            return true;
        }else {
            return false;
        }
    }
    public boolean viewOrders() {
        try {
            if(driver.findElements(By.xpath("//tbody/tr")).size() >= 1)
                System.out.println("There is at least one order.");
                return true;
        } catch (Exception e) {
            if (driver.findElement(By.xpath("//Strong[text()='No orders found.']")).isDisplayed())
                System.out.println("No orders found.");
            return false;
        }
    }
    public boolean editOrderFromOrderNumber(){
        WebElement orderLink=driver.findElement(By.linkText(orderNumber));
        orderLink.click();
        selectOrderStatus();
        functionLibrary.waitForElementPresent(saveButton);
        saveButton.click();
        try{
            if (driver.findElement(By.xpath("//div[text()='Order successfully updated.']")).isDisplayed())
                System.out.println("Order successfully updated.");
                return true;
        }catch (Exception e){
            System.out.println("Update Order failed.");
            return false;
        }
    }
    public boolean editOrderFromEditIcon(){
        WebElement editIcon=driver.findElement(By.xpath(String.format("(//a[text()='%s']//ancestor::tr/td/a[@title='Edit'])[2]",orderNumber)));
        editIcon.click();
        selectOrderStatus();
        functionLibrary.waitForElementPresent(saveButton);
        saveButton.click();
        try{
            if (driver.findElement(By.xpath("//div[text()='Order successfully updated.']")).isDisplayed()){
                System.out.println("Order successfully updated.");
               return true;
            }
        }catch (Exception e){
            System.out.println("Update Order failed.");
        }
        return false;
    }
    public boolean deleteOrder(){
        WebElement deleteIcon=driver.findElement(By.xpath(String.format("//a[text()='%s']//ancestor::tr/td/a[@class='delete']",orderNumber)));
        deleteIcon.click();
        driver.switchTo().alert().accept();
        try{
            if(driver.findElement(By.className("success")).isDisplayed())
                System.out.println("Order: "+orderNumber+" successfully deleted");
            return true;
        }catch (Exception e){
            System.out.println("Delete Failed!!!");
            return false;
        }
    }
    public void deleteOrderWithMonth(int monthNumber){
        functionLibrary.waitForElementPresent(gdprToolsLink);
        gdprToolsLink.click();
        functionLibrary.waitForElementPresent(monthInputField);
        monthInputField.sendKeys(String.valueOf(monthNumber));
        goButton.click();
        driver.switchTo().alert().accept();
    }
}
