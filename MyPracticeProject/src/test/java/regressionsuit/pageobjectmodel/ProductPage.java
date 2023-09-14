package regressionsuit.pageobjectmodel;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import regressionsuit.testngproject.DataBase;
import regressionsuit.cubecartobjects.ProductObject;
import regressionsuit.testngproject.FunctionLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
            @FindBy(className = "success")
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
    public void selectProductCondition(){
        Select select=new Select(conditionDropDown);
        List<String> selectOptions=new ArrayList<>(Arrays.asList(DataBase.condition.NEW.getValue(),
                DataBase.condition.DAMAGED.getValue(), DataBase.condition.USED.getValue(), DataBase.condition.REFURBISHED.getValue()));
        Random random=new Random();
        String toBeSelected=selectOptions.get(random.nextInt(selectOptions.size()));
        select.selectByVisibleText(toBeSelected);
    }
    public void selectDimensionUnit(){
        Select selectDimensionUnit = new Select(dimensionDropDown);
        List<String> selectOptions=new ArrayList<>(Arrays.asList(DataBase.dimensionUnit.CENTIMETERS.getValue(),
                DataBase.dimensionUnit.INCHES.getValue()));
        Random random=new Random();
        String toBeSelected=selectOptions.get(random.nextInt(selectOptions.size()));
        selectDimensionUnit.selectByVisibleText(toBeSelected);
    }

    public void selectTaxType(){
        Select select=new Select(taxDropDown);
        List<String> selectOptions=new ArrayList<>(Arrays.asList(DataBase.taxType.STANDART_TAX.getValue(),
                DataBase.taxType.REDUCED_RATE.getValue(), DataBase.taxType.TAX_EXEMPT.getValue()));
        Random random=new Random();
        String toBeSelected=selectOptions.get(random.nextInt(selectOptions.size()));
        select.selectByVisibleText(toBeSelected);
    }

    public boolean viewProductList() {
        return productList.size() >= 1;
    }
    public void addProduct(ProductObject productObject) {
        addProductLink.click();
        productNameField.sendKeys(productObject.getProductName());
        Select selectManufacturer = new Select(manufacturerDropDown);
        selectManufacturer.selectByVisibleText(productObject.getManufacturer());
        selectProductCondition();
        productCodeField.sendKeys(productObject.getProductCode());
        productWeightField.sendKeys(String.valueOf(productObject.getWeight()));
        selectDimensionUnit();
        productWidthField.sendKeys(String.valueOf(productObject.getWidth()));
        productHeightField.sendKeys(String.valueOf(productObject.getHeight()));
        productDepthField.sendKeys(String.valueOf(productObject.getDepth()));
        liveDateField.sendKeys(productObject.getLiveDate());
        stockLevelField.sendKeys(String.valueOf(productObject.getStockLevel()));
        stockLevelWarningField.sendKeys(String.valueOf(productObject.getStockLevelWarning()));
        upcCodeField.sendKeys(productObject.getUpcCode());
        eanCodeField.sendKeys(productObject.getEanCode());
        janCodeField.sendKeys(productObject.getJanCode());
        isbnCodeField.sendKeys(productObject.getIsbnCode());
        gtinCodeField.sendKeys(productObject.getGtinCode());
        mpnCodeField.sendKeys(productObject.getMpnCode());
        functionLibrary.waitForElementPresent(googleCategoryDropdown);
        googleCategoryDropdown.click();
        googleCategoryInputField.sendKeys(productObject.getGoogleCategory());
        descriptionLink.click();
        driver.switchTo().frame(iframeOfDescription);
        functionLibrary.sleep();
        descriptionInputField.sendKeys(productObject.getDescription());
        driver.switchTo().defaultContent();
        functionLibrary.sleep();
        driver.switchTo().frame(iframeOfShortDescription);
        functionLibrary.waitForElementPresent(shortDescriptionInputField);
        shortDescriptionInputField.sendKeys(productObject.getShortDescription());
        functionLibrary.sleep();
        driver.switchTo().defaultContent();
        pricingLink.click();
        retailPriceField.sendKeys(String.valueOf(productObject.getRetailPrice()));
        salePriceField.sendKeys(String.valueOf(productObject.getSalePrice()));
        costPriceField.sendKeys(String.valueOf(productObject.getCostPrice()));
        selectTaxType();
        taxIncludeCheckBox.click();
        minimumQuantityField.sendKeys(String.valueOf(productObject.getMinQuantity()));
        maximumQuantityField.sendKeys(String.valueOf(productObject.getMaxQuantity()));
        bulkQuantityField.sendKeys(String.valueOf(productObject.getBulkQuantity()));
        bulkPriceField.sendKeys(String.valueOf(productObject.getBulkPrice()));
        plusSign.click();
        functionLibrary.sleep();
        categoriesLink.click();
        functionLibrary.sleep();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement checkbox = driver.findElement(By.xpath(String.format("//td[text()='%s']/preceding-sibling::td/div[@class='custom-checkbox']", productObject.getCategory())));
        js.executeScript("arguments[0].scrollIntoView(true)", checkbox);
        functionLibrary.waitForElementPresent(checkbox);
        checkbox.click();
        WebElement radioButton = driver.findElement(By.xpath(String.format("//td[text()='%s']/preceding-sibling::td/input[@type='radio']", productObject.getCategory())));
        //js.executeScript("arguments[0].scrollIntoView(true)",radioButton);
        functionLibrary.waitForElementPresent(radioButton);
        radioButton.click();

        functionLibrary.sleep();
        searchEnginesLink.click();
        metaTitleField.sendKeys(productObject.getMetaTitle());
        seoURLPathField.sendKeys(productObject.getSeoPath());
        metaDescriptionField.sendKeys(productObject.getMetaDescription());
        saveButton.click();
        System.out.println("Product name is: " + productObject.getProductName());
    }

    public void addProduct(String productName,String manufacturer,String productCode,String productWeight,
                         String productWidth,String productHeight,String productDepth,
                           String liveDate,int stockLevel, int stockLevelWarning,String upcCode,String eanCode,
                           String janCode,String isbnCode,String gtinCode,String mpnCode,String googleCategory,
                           String description, String shortDescription,double retailPrice,double salePrice,
                           double costPrice,int minQuantity, int maxQuantity,int bulkQuantity, double bulkPrice,
                           String category,String metaTitle,String seoPath,String metaDescription) {
        addProductLink.click();
        productNameField.sendKeys(productName);
        Select selectManufacturer = new Select(manufacturerDropDown);
        selectManufacturer.selectByVisibleText(manufacturer);
        selectProductCondition();
        productCodeField.sendKeys(productCode);
        productWeightField.sendKeys(productWeight);
        selectDimensionUnit();
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
        driver.switchTo().defaultContent();
        pricingLink.click();
        retailPriceField.sendKeys(String.valueOf(retailPrice));
        salePriceField.sendKeys(String.valueOf(salePrice));
        costPriceField.sendKeys(String.valueOf(costPrice));
        selectTaxType();
        taxIncludeCheckBox.click();
        minimumQuantityField.sendKeys(String.valueOf(minQuantity));
        maximumQuantityField.sendKeys(String.valueOf(maxQuantity));
        bulkQuantityField.sendKeys(String.valueOf(bulkQuantity));
        bulkPriceField.sendKeys(String.valueOf(bulkPrice));
        plusSign.click();
        functionLibrary.sleep();
        categoriesLink.click();
        functionLibrary.sleep();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        WebElement checkbox=driver.findElement(By.xpath(String.format("//td[text()='%s']/preceding-sibling::td/div[@class='custom-checkbox']",category)));
        js.executeScript("arguments[0].scrollIntoView(true)",checkbox);
        functionLibrary.waitForElementPresent(checkbox);
        checkbox.click();
        WebElement radioButton=driver.findElement(By.xpath(String.format("//td[text()='%s']/preceding-sibling::td/input[@type='radio']",category)));
        //js.executeScript("arguments[0].scrollIntoView(true)",radioButton);
        functionLibrary.waitForElementPresent(radioButton);
        radioButton.click();

        functionLibrary.sleep();
        searchEnginesLink.click();
        metaTitleField.sendKeys(metaTitle);
        seoURLPathField.sendKeys(seoPath);
        metaDescriptionField.sendKeys(metaDescription);
        saveButton.click();
        System.out.println("Product name is: "+productName);
    }
    public boolean verifyProductAddedSuccessfully() {
        return successMessage.size()>=1;
    }
}

