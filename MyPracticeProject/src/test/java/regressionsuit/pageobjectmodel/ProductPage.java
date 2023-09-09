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
    @FindBy(css = "[title='Rich Text Editor, description']")
    WebElement iframeOfDescription;
    @FindBy(css = "[title='Rich Text Editor, description_short']")
    WebElement iframeOfShortDescription;
    @FindBy(css = ".cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders:first-of-type")
    WebElement descriptionInputField;
    @FindBy(css = ".cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders:last-of-type")
    WebElement shortDescriptionInputField;
    @FindBy(xpath = "//a[@href=\"#pricing\"]")
    WebElement pricingLink;
    @FindBy(id = "price")
    WebElement retailPriceField;
    @FindBy(id = "sale_price")
    WebElement salePriceField;
    @FindBy(id = "cost_price")
    WebElement costPriceField;
    @FindBy(id = "tax_type")
    WebElement taxDropDown;
    @FindBy(css = "[rel='#tax_inclusive']")
    WebElement taxIncludeCheckBox;
    @FindBy(id = "minimum_quantity")
    WebElement minimumQuantityField;
    @FindBy(id = "maximum_quantity")
    WebElement maximumQuantityField;
    @FindBy(css = "tr[id='qty_discounts'] td input[rel='quantity']")
    WebElement bulkQuantityField;
    @FindBy(css = "tr[id='qty_discounts'] td input[rel='price']")
    WebElement bulkPriceField;
    @FindBy(css = "a[target='qty_discounts'] i")
    WebElement plusSign;
    @FindBy(xpath = "//a[@href=\"#category\"]")
    WebElement categoriesLink;
    @FindBy(linkText = "Search Engines")
    WebElement searchEnginesLink;
    @FindBy(id = "seo_meta_title")
    WebElement metaTitleField;
    @FindBy(id = "seo_path")
    WebElement seoURLPathField;
    @FindBy(id = "seo_meta_description")
    WebElement metaDescriptionField;
    @FindBy(css ="input[value='Save']")
    WebElement saveButton;
    @FindAll(
            @FindBy(className = "\"success\"")
    )
    List<WebElement> successMessage;
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
                           String janCode,String isbnCode,String gtinCode,String mpnCode,String googleCategory,
                           String description, String shortDescription,double retailPrice,double salePrice,
                           String costPrice,String taxType,int minQuantity, int maxQuantity,int bulkQuantity, double bulkPrice,
                           String categories,String metaTitle,String seoPath,String metaDescription) {
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
        descriptionLink.click();
        driver.switchTo().frame(iframeOfDescription);
        functionLibrary.sleep();
        descriptionInputField.sendKeys(description);
        driver.switchTo().defaultContent();
        functionLibrary.sleep();
        driver.switchTo().frame(iframeOfShortDescription);
        functionLibrary.waitForElementPresent(shortDescriptionInputField);
        shortDescriptionInputField.sendKeys(shortDescription);
        functionLibrary.sleep();
        pricingLink.click();
        retailPriceField.sendKeys(String.valueOf(retailPrice));
        salePriceField.sendKeys(String.valueOf(salePrice));
        costPriceField.sendKeys(String.valueOf(costPrice));
        Select selectTax=new Select(taxDropDown);
        selectTax.selectByVisibleText(taxType);
        taxIncludeCheckBox.click();
        minimumQuantityField.sendKeys(String.valueOf(minQuantity));
        maximumQuantityField.sendKeys(String.valueOf(maxQuantity));
        bulkQuantityField.sendKeys(String.valueOf(bulkQuantity));
        bulkPriceField.sendKeys(String.valueOf(bulkPrice));
        plusSign.click();
        functionLibrary.sleep();
        categoriesLink.click();
        functionLibrary.sleep();
        WebElement radioButton=driver.findElement(By.xpath(String.format("(//td[text()='%s']/preceding-sibling::td/input[@type='radio'])[1]",categories)));
        radioButton.click();
        WebElement checkbox=driver.findElement(By.xpath(String.format("(//td[text()='%s']/preceding-sibling::td/*[@class='custom-checkbox'])[1]",categories)));
        checkbox.click();
        functionLibrary.sleep();
        searchEnginesLink.click();
        metaTitleField.sendKeys(metaTitle);
        seoURLPathField.sendKeys(seoPath);
        metaDescriptionField.sendKeys(metaDescription);
        saveButton.click();
    }
    public boolean verifyProductAddedSuccessfully() {
        functionLibrary.sleep();
        return successMessage.size()>=1;
    }
}

