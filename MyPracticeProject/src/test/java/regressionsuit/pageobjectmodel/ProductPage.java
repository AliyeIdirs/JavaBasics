package regressionsuit.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    @FindBy(linkText = "Add Product")
    WebElement addProductLink;
    @FindBy(id = "name")
    WebElement productNameField;
    @FindBy(id = "manufacturer")
    WebElement manufacturerDropDown;
    @FindBy(id = "condition")
    WebElement conditionDropDown;
    @FindBy(id = "product_code")
    WebElement productCodeField;
    @FindBy(id = "product_weight")
    WebElement productWeightField;
    @FindBy(id = "dimension_unit")
    WebElement dimensionDropDown;
    @FindBy(id = "product_width")
    WebElement productWidthField;
    @FindBy(id = "product_height")
    WebElement productHeightField;
    @FindBy(id = "product_depth")
    WebElement productDepthField;
    @FindBy(id = "live_from")
    WebElement liveDateField;
    @FindBy(id = "stock_level")
    WebElement stockLevelField;
    @FindBy(id = "stock_warning")
    WebElement stockLevelWarningField;
    @FindBy(id = "upc")
    WebElement upcCodeField;
    @FindBy(id = "ean")
    WebElement eanCodeField;
    @FindBy(id = "jan")
    WebElement janCodeField;
    @FindBy(id = "isbn")
    WebElement isbnCodeField;
    @FindBy(id = "gtin")
    WebElement gtinCodeField;
    @FindBy(id = "mpn")
    WebElement mpnCodeField;
    @FindBy(id = "google_category_chosen")
    WebElement googleCategoryDropdown;
    @FindBy(xpath = "//*[@id=\"google_category_chosen\"]/div/div/input")
    WebElement googleCategoryInputField;
    @FindBy(linkText = "Description")
    WebElement descriptionLink;
    @FindBy(xpath =" //*[@id=\"page_content\"]/form/div[10]/input[3]")
    WebElement saveButton;
    @FindAll(
            @FindBy(xpath = "//div[@id='general']/table[3]/tbody/tr")
    )
    List<WebElement> productList;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }

    public boolean viewProductList() {
        return productList.size() >= 1;
    }

    public void addProduct(String productName,String manufacturer,String condition,String productCode,String productWeight,
                           String dimensionUnit,String productWidth,String productHeight,String productDepth,
                           String liveDate,int stockLevel, int stockLevelWarning,String upcCode,String eanCode,
                           String janCode,String isbnCode,String gtinCode,String mpnCode,String googleCategory) {
        addProductLink.click();
        productNameField.sendKeys(productName);
        Select selectManufacturer = new Select(manufacturerDropDown);
        selectManufacturer.selectByVisibleText(manufacturer);
        Select selectCondition = new Select(conditionDropDown);
        List<WebElement> conditions = selectCondition.getOptions();
        for (WebElement element : conditions) {
            String conditionText = element.getText();
            if (conditionText.equalsIgnoreCase(condition)) {
                element.click();
            }
        }
        productCodeField.sendKeys(productCode);
        productWeightField.sendKeys(productWeight);
        Select selectDimensionUnit = new Select(dimensionDropDown);
        List<WebElement> dimensions = selectDimensionUnit.getOptions();
        for (WebElement dimension : dimensions) {
            String dimensionText = dimension.getText();
            if (dimensionText.contains(dimensionUnit)) {
                dimension.click();
                break;
            }
        }
        productWidthField.sendKeys(productWidth);
        productHeightField.sendKeys(productHeight);
        productDepthField.sendKeys(productDepth);
        liveDateField.sendKeys(liveDate);
        stockLevelField.sendKeys(String.valueOf(stockLevel));
        stockLevelWarningField.sendKeys(String.valueOf(stockLevelWarning));
        upcCodeField.sendKeys(upcCode);
        eanCodeField.sendKeys(eanCode);
        janCodeField.sendKeys(janCode);
        isbnCodeField.sendKeys(isbnCode);
        gtinCodeField.sendKeys(gtinCode);
        mpnCodeField.sendKeys(mpnCode);
        googleCategoryDropdown.click();
        googleCategoryInputField.sendKeys(googleCategory);
        saveButton.click();
    }

    public boolean verifyProductAddedSuccessfully() {
        functionLibrary.sleep();
        WebElement successMessage = driver.findElement(By.className("success"));
        regressionsuit.week16junitproject.FunctionLibrary.waitElementPresent(successMessage);
        return successMessage.isDisplayed();
    }
}

