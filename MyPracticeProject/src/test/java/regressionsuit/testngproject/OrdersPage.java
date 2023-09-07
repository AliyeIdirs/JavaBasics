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

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }
    @FindBy(linkText = "Create Order")
    WebElement createOrderLink;
    @FindBy(linkText = "Inventory")
    WebElement inventoryLink;
    @FindBy(xpath = "//tr[@class='update-subtotal inline-add']//*[@rel='product_quantity']")
    WebElement quantityField;
    @FindBy(id = "ajax_name")
    WebElement productNameField;
    @FindAll(
            @FindBy(xpath = "//div[text()='Order successfully created.']")
    )
    List<WebElement> verifyMessage;

}
