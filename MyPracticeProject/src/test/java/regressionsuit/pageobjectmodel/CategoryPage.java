package regressionsuit.pageobjectmodel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import regressionsuit.cubecartobjects.ProductCategoryObject;
import regressionsuit.testngproject.FunctionLibrary;

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
    @FindBy(linkText = "Description")
    WebElement descriptionLink;
    @FindBy(linkText = "Search Engines")
    WebElement searchEngineLink;
    @FindBy(id = "seo_meta_title")
    WebElement metaTitleField;
    @FindBy(id = "seo_path")
    WebElement seoPathField;
    @FindBy(id = "seo_meta_description")
    WebElement metaDescriptionField;
    @FindBy(className="success")
    WebElement successMessage;
    @FindBy(id = "tab_cat_images")
    WebElement imagesLink;
    @FindBy(xpath = "//input[@type='file']")
    WebElement uploadFileButton;
    @FindBy(xpath = "//span[text()='Select File']")
    WebElement selectImageButton;
    @FindAll(
            @FindBy(xpath = "//tbody[@class='reorder-list ui-sortable']/tr")
    )
    List<WebElement> allCategoriesList;
    @FindBy(css = ".success")
    WebElement updateSuccessMessage;

    public void addCategory(ProductCategoryObject productCategoryObject){
        functionLibrary.waitForElementPresent(addCategoryLink);
        addCategoryLink.click();
        statusCheckBox.click();
        visibleCheckBox.click();
        categoryNameField.sendKeys(productCategoryObject.getCategoryName());
        functionLibrary.waitForElementPresent(descriptionLink);
        descriptionLink.click();
        driver.switchTo().frame(0);
        WebElement editField=driver.findElement(By.cssSelector("body[class*='cke_editable']"));
        editField.sendKeys(productCategoryObject.getDescription());
        functionLibrary.sleep(1);
        driver.switchTo().defaultContent();
        functionLibrary.waitForElementPresent(imagesLink);
        imagesLink.click();
        functionLibrary.waitForElementPresent(selectImageButton);
        selectImageButton.click();
        uploadFileButton.sendKeys("/Users/user/Documents/Desktop Pics/image-from-rawpixel-id-3814725-jpeg.jpg");
        functionLibrary.waitForElementPresent(searchEngineLink);
        searchEngineLink.click();
        metaTitleField.sendKeys(productCategoryObject.getMetaTitle());
        seoPathField.sendKeys(productCategoryObject.getSeoPath());
        metaDescriptionField.sendKeys(productCategoryObject.getMetaDescription());
        saveButton.click();
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
    public boolean categoryExistInTheList(String catName){
        for (WebElement eachCat:allCategoriesList){
            WebElement name=eachCat.findElement(By.xpath("td[5]"));
            if (name.getText().equals(catName)){
                WebElement id=eachCat.findElement(By.xpath("td/strong"));
                System.out.println("New category is created with Id "+id.getText());
                return true;
            }
        }
        return false;
    }
    public void updateCategory(String newCatName,int categoryId){
        WebElement targetEditIcon=driver.findElement(By.xpath(String.format("//a[contains(@href,'%d') and @title='Edit']",categoryId)));
        functionLibrary.waitForElementPresent(targetEditIcon);
        targetEditIcon.click();
        WebElement nameField=driver.findElement(By.id("cat_name"));
        nameField.clear();
        nameField.sendKeys(newCatName);
        saveButton.click();
    }
    public boolean verifyCategoryUpdated(){
        if (updateSuccessMessage.isDisplayed()) {
            System.out.println(updateSuccessMessage.getText());
            return true;
        }else
            return false;
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
