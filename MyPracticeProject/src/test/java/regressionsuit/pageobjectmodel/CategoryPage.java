package regressionsuit.pageobjectmodel;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import regressionsuit.cubecartobjects.ProductCategoryObject;

import java.util.List;

public class CategoryPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }
    @FindBy(css = ".fa.fa-trash")
    WebElement deleteIcon;
    @FindAll(@FindBy(xpath = "//*[contains(text(),'deleted.')]"))
    List<WebElement> deleteSuccessMessages;
    @FindBy(linkText = "Add Category")
    WebElement addCategoryLink;
    @FindBy(css="img[rel=\"#status\"]")
    WebElement statusCheckBox;
    @FindBy(css="img[rel=\"#visible\"]")
    WebElement visibleCheckBox;
    @FindBy(id="name")
    WebElement categoryNameField;
    @FindBy(id="cat_save")
    WebElement saveButton;
    @FindAll(@FindBy(className="success"))
    List<WebElement> addSuccessMessage;
    @FindBy(id = "parent")
    WebElement parentDropDown;

    public void addCategory(ProductCategoryObject productCategoryObject){
        addCategoryLink.click();
        statusCheckBox.click();
        visibleCheckBox.click();
        categoryNameField.sendKeys(productCategoryObject.getCategoryName());
        saveButton.click();
        System.out.println("Product category name: "+productCategoryObject.getCategoryName());

    }
    public void addCategoryWithParentCategory(ProductCategoryObject productCategoryObject){
        addCategory(productCategoryObject);
        addCategoryLink.click();
        statusCheckBox.click();
        visibleCheckBox.click();
        categoryNameField.sendKeys(productCategoryObject.getCategoryName());
        Select select=new Select(parentDropDown);
        select.selectByVisibleText("/"+productCategoryObject.getParentCategoryName());
        saveButton.click();
    }
    public boolean verifyCategoryAdded(){
        return addSuccessMessage.size()>=1;

    }
    public void deleteCategory(){
        functionLibrary.waitForElementPresent(deleteIcon);
        deleteIcon.click();
        Alert alert= driver.switchTo().alert();
        functionLibrary.waitAlertPresent();
        alert.accept();
    }
    public boolean verifyCategoryDeleted(){
        return deleteSuccessMessages.size()>=1;
    }
}
