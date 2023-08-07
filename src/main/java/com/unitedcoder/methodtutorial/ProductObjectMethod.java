package com.unitedcoder.methodtutorial;

import com.unitedcoder.cubecartautomation.LoginUser;
import com.unitedcoder.cubecartautomation.ProductInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.Formatter;
import java.util.List;

public class ProductObjectMethod {
    WebDriver driver;   // define properties
    public ProductObjectMethod() {  //set default constructor
    }
    public ProductObjectMethod(WebDriver driver) {
        this.driver = driver;
    }  //set constructor with WebDriver parameter

    //we use login method in the CustomerObjectMethod here

    //driver setup method
    public void driverSetUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver= new ChromeDriver(options);
        driver.manage().window().maximize();

    }

    //login method
    public void logIn(LoginUser loginUser){
        driver.get("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        WebElement userNameField= driver.findElement(By.id("username"));
        userNameField.sendKeys(loginUser.getUserName());
        WebElement passwordField=driver.findElement(By.id("password"));
        passwordField.sendKeys(loginUser.getPassword());
        WebElement loginButton=driver.findElement(By.id("login"));
        loginButton.click();
    }

    //Add product method
    public void addProduct(ProductInfo productInfo) {
        WebElement expandIcon = driver.findElement(By.cssSelector(".fa.fa-minus-square-o"));
        if (expandIcon.isEnabled()) {
            expandIcon.click();
        }
        WebElement products = driver.findElement(By.id("nav_products")); products.click();
        WebElement addProduct = driver.findElement(By.linkText("Add Product")); addProduct.click();
        WebElement status = driver.findElement(By.xpath("//img[@rel='#product_status']"));
        if (!status.isEnabled()) {
            status.click();
        }
        WebElement productName = driver.findElement(By.id("name"));
        productName.sendKeys(productInfo.getProductName());

        WebElement manufacturer = driver.findElement(By.id("manufacturer"));
        Select selectManufacturer = new Select(manufacturer);
        selectManufacturer.selectByVisibleText("manufacturer1");

        WebElement condition = driver.findElement(By.id("condition"));
        Select selectCondition = new Select(condition);
        List<WebElement> conditions = selectCondition.getOptions();
        for (WebElement element : conditions) {
            String conditionText = element.getText();
            if (conditionText.equalsIgnoreCase("New")) {
                element.click();
            }
        }

        WebElement productCode = driver.findElement(By.id("product_code"));
        productCode.sendKeys(productInfo.getProductCode());

        WebElement autoGenerateProductCode = driver.findElement(By.xpath("//img[@rel=\"#product_code_auto\"]"));
        if (autoGenerateProductCode.isEnabled()) {
            autoGenerateProductCode.click();
        }

        WebElement weight = driver.findElement(By.id("product_weight")); weight.sendKeys(productInfo.getWeight());

        WebElement dimensionUnit = driver.findElement(By.id("dimension_unit"));
        Select selectDimensionUnit = new Select(dimensionUnit);
        List<WebElement> dimensions = selectDimensionUnit.getOptions();
        for (int i = 0; i < dimensions.size(); i++) {
            String dimensionText = dimensions.get(i).getText();
            if (dimensionText.equalsIgnoreCase("Centimeters (cm)")) {
                dimensions.get(i).click();
                break;
            }
        }

        WebElement width = driver.findElement(By.id("product_width")); width.sendKeys(productInfo.getWidth());

        WebElement height = driver.findElement(By.id("product_height")); height.sendKeys(productInfo.getHeight());

        WebElement depth = driver.findElement(By.id("product_depth")); depth.sendKeys(productInfo.getDepth());

        WebElement featuredProductCheckBox = driver.findElement(By.xpath("//img[@rel=\"#product_featured\"]"));
        if (!featuredProductCheckBox.isEnabled()) {
            featuredProductCheckBox.click();
        }

        WebElement latestProductCheckBox = driver.findElement(By.xpath("//img[@rel=\"#product_latest\"]"));
        if (!latestProductCheckBox.isEnabled()) {
            latestProductCheckBox.click();
        }


        WebElement availableForPurchaseCheckBox = driver.findElement(By.xpath("//img[@rel=\"#available\"]"));
        if (!availableForPurchaseCheckBox.isEnabled()) {
            availableForPurchaseCheckBox.click();
        }

        WebElement liveTime= driver.findElement(By.id("live_from"));
        DateTime time= new DateTime();
        DateTimeFormatter formatter= DateTimeFormat.forPattern("yyyy hh:mm:ss");
        liveTime.sendKeys(time.dayOfMonth().get()+" " +time.monthOfYear().getAsText()+" "+ time.toString(formatter));

        WebElement useStockLevelCheckBox= driver.findElement(By.xpath("//img[@rel=\"#use_stock_level\"]"));
        if (!useStockLevelCheckBox.isEnabled()){
            useStockLevelCheckBox.click();
        }

        WebElement stockLevel= driver.findElement(By.id("stock_level"));
        stockLevel.sendKeys(Integer.toString(productInfo.getStockLevel()));

        WebElement stockWarning= driver.findElement(By.id("stock_warning"));
        stockWarning.sendKeys(Integer.toString(productInfo.getStockLevelWarming()));

        WebElement upcCode= driver.findElement(By.id("upc")); upcCode.sendKeys(productInfo.getUpcCode());

        WebElement eanCode= driver.findElement(By.id("ean")); eanCode.sendKeys(productInfo.getEanCode());

        WebElement janCode= driver.findElement(By.id("jan")); janCode.sendKeys(productInfo.getJanCode());

        WebElement isbnCode= driver.findElement(By.id("isbn")); isbnCode.sendKeys(productInfo.getIsbnCode());

        WebElement gtinCode= driver.findElement(By.id("gtin")); gtinCode.sendKeys(productInfo.getGtinCode());

        WebElement mpnCode= driver.findElement(By.id("mpn")); mpnCode.sendKeys(productInfo.getMpnCode());

        WebElement googleCategoryDropdown= driver.findElement(By.className("chosen-single"));
        googleCategoryDropdown.click();

        WebElement categoryKeyWord= driver.findElement(By.xpath("//*[@id=\"google_category_chosen\"]/div/div/input"));
        categoryKeyWord.click();

        driver.findElement(By.xpath("//li[@data-option-array-index=\"127\"]")).click();

        WebElement saveButton= driver.findElement(By.xpath("//*[@id=\"page_content\"]/form/div[10]/input[3]"));
        saveButton.click();

    }
    //verify method
    public boolean verifyAddProductSuccessful(){
        WebElement successMessage= driver.findElement(By.className("success"));
        if (successMessage.isDisplayed()){
            System.out.println("Product Added Successfully");
            return true;
        } else{
            System.out.println("Add Product Failed!");
            return false;
        }
    }

    //logout method
    public void logOut(){
        WebElement logOutLink=driver.findElement(By.cssSelector(".fa.fa-sign-out"));
        logOutLink.click();
    }

    //quit browser
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
