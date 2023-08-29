package regressionsuit.week16junitproject;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestLibrary extends TestBase{
    FunctionLibrary functionLibrary=new FunctionLibrary();
    String productCode="";
    public void addProduct(ProductObject productObject){
            WebElement products = driver.findElement(By.id("nav_products"));
            products.click();
            WebElement addProduct = driver.findElement(By.linkText("Add Product"));
            addProduct.click();
            WebElement productName = driver.findElement(By.id("name"));
            productName.sendKeys(productObject.getProductName());
            WebElement manufacturer = driver.findElement(By.id("manufacturer"));
            Select selectManufacturer = new Select(manufacturer);
            selectManufacturer.selectByVisibleText(productObject.getManufacturer());
            WebElement condition = driver.findElement(By.id("condition"));
            Select selectCondition = new Select(condition);
            List<WebElement> conditions = selectCondition.getOptions();
            for (WebElement element : conditions) {
                String conditionText = element.getText();
                if (conditionText.equalsIgnoreCase(productObject.getCondition())) {
                    element.click();
                }
            }
            WebElement productCodeField = driver.findElement(By.id("product_code"));
            productCode=productObject.getProductCode();
            productCodeField.sendKeys(productCode);
            WebElement weight = driver.findElement(By.id("product_weight"));
            weight.sendKeys(String.valueOf(productObject.getProductWeight()));
            WebElement dimensionUnit = driver.findElement(By.id("dimension_unit"));
            Select selectDimensionUnit = new Select(dimensionUnit);
            List<WebElement> dimensions = selectDimensionUnit.getOptions();
            for (WebElement dimension : dimensions) {
                String dimensionText = dimension.getText();
                if (dimensionText.contains(productObject.getDimensionUnit())) {
                    dimension.click();
                    break;
                }
            }
            WebElement width = driver.findElement(By.id("product_width"));
            width.sendKeys(String.valueOf(productObject.getProductWidth()));

            WebElement height = driver.findElement(By.id("product_height"));
            height.sendKeys(String.valueOf(productObject.getProductHeight()));

            WebElement depth = driver.findElement(By.id("product_depth"));
            depth.sendKeys(String.valueOf(productObject.getProductDepth()));

            WebElement liveTime = driver.findElement(By.id("live_from"));
            liveTime.sendKeys(productObject.getLiveDate());

            WebElement stockLevel = driver.findElement(By.id("stock_level"));
            stockLevel.sendKeys(Integer.toString(productObject.getStockLevel()));

            WebElement stockWarning = driver.findElement(By.id("stock_warning"));
            stockWarning.sendKeys(Integer.toString(productObject.getStockLevelWarning()));

            WebElement upcCode = driver.findElement(By.id("upc"));
            upcCode.sendKeys(productObject.getUpcCode());

            WebElement eanCode = driver.findElement(By.id("ean"));
            eanCode.sendKeys(productObject.getEanCode());
            WebElement janCode = driver.findElement(By.id("jan"));
            janCode.sendKeys(productObject.getJanCode());
            WebElement isbnCode = driver.findElement(By.id("isbn"));
            isbnCode.sendKeys(productObject.getIsbnCode());
            WebElement gtinCode = driver.findElement(By.id("gtin"));
            gtinCode.sendKeys(productObject.getGtinCode());
            WebElement mpnCode = driver.findElement(By.id("mpn"));
            mpnCode.sendKeys(productObject.getMpnCode());

            WebElement googleCategoryDropdown = driver.findElement(By.id("google_category_chosen"));
            googleCategoryDropdown.click();
            WebElement categoryInput = driver.findElement(By.xpath("//*[@id=\"google_category_chosen\"]/div/div/input"));
            categoryInput.sendKeys(productObject.getGoogleCategory(), Keys.ENTER);

            WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"page_content\"]/form/div[10]/input[3]"));
            saveButton.click();
    }

    public boolean verifyProductAddedSuccessfully(){
        WebElement successMessage = driver.findElement(By.className("success"));
        return successMessage.isDisplayed();
    }

    public void deleteProduct() {
        WebElement products = driver.findElement(By.id("nav_products"));
        products.click();
        WebElement deleteIcon = driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]//parent::tr//following-sibling::td//a/i[@title='Delete']", productCode)));
        deleteIcon.click();
        Alert alert = driver.switchTo().alert();
        functionLibrary.waitAlertPresent();
        alert.accept();
    }
        public boolean verifyProductDeleteSuccessfully(){
            WebElement successMessage = driver.findElement(By.id("gui_message"));
            functionLibrary.waitElementPresent(successMessage);
            if(successMessage.isDisplayed()){
                return true;
            }else{
                return false;
            }
    }
}
