package com.unitedcoder.homework.week13cubecartautomation;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.*;
import java.util.*;

public class Methods extends DriverActions {
    public static List<Product> readProductInfo(String fileName, String sheetName) {

        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<Product> products = new ArrayList<>();
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        for (int r = 1; r <= rowCount; r++) {
            XSSFRow row = sheet.getRow(r);
            int c = 0;
            XSSFCell status = row.getCell(c);
            XSSFCell productName = row.getCell(++c);
            XSSFCell manufacturer = row.getCell(++c);
            XSSFCell condition = row.getCell(++c);
            XSSFCell productCode = row.getCell(++c);
            XSSFCell autoGenerateProductCode = row.getCell(++c);
            XSSFCell weight = row.getCell(++c);
            XSSFCell dimensionUnit = row.getCell(++c);
            XSSFCell width = row.getCell(++c);
            XSSFCell height = row.getCell(++c);
            XSSFCell depth = row.getCell(++c);
            XSSFCell includeInFeaturedProduct = row.getCell(++c);
            XSSFCell includeInLatestProduct = row.getCell(++c);
            XSSFCell availableForPurchase = row.getCell(++c);
            XSSFCell listDate = row.getCell(++c);
            XSSFCell useStockLevel = row.getCell(++c);
            XSSFCell stockLevel = row.getCell(++c);
            XSSFCell stockLevelWarning = row.getCell(++c);
            XSSFCell upcCode = row.getCell(++c);
            XSSFCell eanCode = row.getCell(++c);
            XSSFCell janCode = row.getCell(++c);
            XSSFCell isbnCode = row.getCell(++c);
            XSSFCell gtinCode = row.getCell(++c);
            XSSFCell mpnCode = row.getCell(++c);
            XSSFCell googleCategory = row.getCell(++c);
            products.add(new Product(String.valueOf(status.getBooleanCellValue()), productName.getStringCellValue() + timeStamp(), manufacturer.getStringCellValue(),
                    condition.getStringCellValue(), productCode.getStringCellValue() + timeStamp(), String.valueOf(autoGenerateProductCode.getBooleanCellValue()),
                    weight.getNumericCellValue(), dimensionUnit.getStringCellValue(), width.getNumericCellValue(), height.getNumericCellValue(),
                    depth.getNumericCellValue(), String.valueOf(includeInFeaturedProduct.getBooleanCellValue()), String.valueOf(includeInLatestProduct.getBooleanCellValue()),
                    String.valueOf(availableForPurchase.getBooleanCellValue()), listDate.getStringCellValue(), String.valueOf(useStockLevel.getBooleanCellValue()),
                    (int) stockLevel.getNumericCellValue(), (int) stockLevelWarning.getNumericCellValue(), upcCode.getStringCellValue() + timeStamp(),
                    eanCode.getStringCellValue() + timeStamp(), janCode.getStringCellValue() + timeStamp(), isbnCode.getStringCellValue() + timeStamp(), gtinCode.getStringCellValue() + timeStamp(),
                    mpnCode.getStringCellValue() + timeStamp(), googleCategory.getStringCellValue()));

        }
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
        return products;

    }

    public static void writeTestReport(String fileName, String sheetName, List<String[]> reportContent) {
        String filePath = mainFolder + separator + fileName;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);
        XSSFRow headerRow = sheet.createRow(0);
        for (int j = 0; j < reportContent.get(0).length; j++) {
            XSSFCell headerCell = headerRow.createCell(j);
            headerCell.setCellValue(reportContent.get(0)[j]);
        }
        int rowCount = reportContent.size();
        int cellCount = headerRow.getLastCellNum();
        for (int r = 1; r < rowCount; r++) {
            XSSFRow contentRow = sheet.createRow(r);
            for (int c = 0; c < cellCount; c++) {
                XSSFCell cell = contentRow.createCell(c);
                cell.setCellValue(reportContent.get(r)[c]);
            }
        }
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Report has been created successfully");
    }

    public static void addProducts(List<Product> productList) {
        try {
            for (Product product : productList) {
                WebElement products = driver.findElement(By.id("nav_products"));
                products.click();
                WebElement addProduct = driver.findElement(By.linkText("Add Product"));
                addProduct.click();

                WebElement status = driver.findElement(By.xpath("//img[@rel='#product_status']"));
                if (product.isStatus().equalsIgnoreCase("true")) {
                    if (!status.isEnabled()) {
                        status.click();
                    }
                } else {
                    if (status.isEnabled()) {
                        status.click();
                    }
                }

                WebElement productName = driver.findElement(By.id("name"));
                productName.sendKeys(product.getProductName());
                WebElement manufacturer = driver.findElement(By.id("manufacturer"));
                Select selectManufacturer = new Select(manufacturer);
                selectManufacturer.selectByVisibleText(product.getManufacturer());

                WebElement condition = driver.findElement(By.id("condition"));
                Select selectCondition = new Select(condition);
                List<WebElement> conditions = selectCondition.getOptions();
                for (WebElement element : conditions) {
                    String conditionText = element.getText();
                    if (conditionText.equalsIgnoreCase(product.getCondition())) {
                        element.click();
                    }
                }

                WebElement productCode = driver.findElement(By.id("product_code"));
                productCode.sendKeys(product.getProductCode());

                WebElement autoGenerateProductCode = driver.findElement(By.xpath("//img[@rel=\"#product_code_auto\"]"));
                if (Boolean.parseBoolean(product.isAutoGenerateProductCode())) {
                    autoGenerateProductCode.click();
                }

                WebElement weight = driver.findElement(By.id("product_weight"));
                weight.sendKeys(String.valueOf(product.getWeight()));

                WebElement dimensionUnit = driver.findElement(By.id("dimension_unit"));
                Select selectDimensionUnit = new Select(dimensionUnit);
                List<WebElement> dimensions = selectDimensionUnit.getOptions();
                for (WebElement dimension : dimensions) {
                    String dimensionText = dimension.getText();
                    if (dimensionText.contains(product.getDimensionUnit())) {
                        dimension.click();
                        break;
                    }
                }

                WebElement width = driver.findElement(By.id("product_width"));
                width.sendKeys(String.valueOf(product.getWidth()));

                WebElement height = driver.findElement(By.id("product_height"));
                height.sendKeys(String.valueOf(product.getHeight()));

                WebElement depth = driver.findElement(By.id("product_depth"));
                depth.sendKeys(String.valueOf(product.getDepth()));

                WebElement featuredProductCheckBox = driver.findElement(By.xpath("//img[@rel=\"#product_featured\"]"));
                if (Boolean.parseBoolean(product.isIncludeInFeaturedProduct())) {
                    if (!featuredProductCheckBox.isEnabled()) {
                        featuredProductCheckBox.click();
                    }
                } else {
                    if (featuredProductCheckBox.isEnabled()) {
                        featuredProductCheckBox.click();
                    }
                }

                WebElement latestProductCheckBox = driver.findElement(By.xpath("//img[@rel=\"#product_latest\"]"));
                if (Boolean.parseBoolean(product.isIncludeInLatestProduct())) {
                    if (!latestProductCheckBox.isEnabled()) {
                        latestProductCheckBox.click();
                    }
                } else {
                    if (latestProductCheckBox.isEnabled()) {
                        latestProductCheckBox.click();
                    }
                }

                WebElement availableForPurchaseCheckBox = driver.findElement(By.xpath("//img[@rel=\"#available\"]"));
                if (Boolean.parseBoolean(product.isAvailableForPurchase())) {
                    if (!availableForPurchaseCheckBox.isEnabled()) {
                        availableForPurchaseCheckBox.click();
                    }
                } else {
                    if (availableForPurchaseCheckBox.isEnabled()) {
                        availableForPurchaseCheckBox.click();
                    }
                }
                WebElement liveTime = driver.findElement(By.id("live_from"));
                DateTime time = new DateTime();
                DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy hh:mm:ss");
                liveTime.sendKeys(time.dayOfMonth().get() + " " + time.monthOfYear().getAsText() + " " + time.toString(formatter));

                WebElement useStockLevelCheckBox = driver.findElement(By.xpath("//img[@rel=\"#use_stock_level\"]"));
                if (Boolean.parseBoolean(product.isUseStockLevel())) {
                    if (!useStockLevelCheckBox.isEnabled()) {
                        useStockLevelCheckBox.click();
                    }
                } else {
                    if (useStockLevelCheckBox.isEnabled()) {
                        useStockLevelCheckBox.click();
                    }
                }

                WebElement stockLevel = driver.findElement(By.id("stock_level"));
                if (!(product.getStockLevel() == 0)) {
                    stockLevel.sendKeys(Integer.toString(product.getStockLevel()));
                } else {
                    stockLevel.sendKeys(String.valueOf((int) (Math.random() * 100) + 1));
                }

                WebElement stockWarning = driver.findElement(By.id("stock_warning"));
                stockWarning.sendKeys(Integer.toString(product.getStockLevelWarning()));

                WebElement upcCode = driver.findElement(By.id("upc"));
                upcCode.sendKeys(product.getUpcCode());

                WebElement eanCode = driver.findElement(By.id("ean"));
                eanCode.sendKeys(product.getEanCode());
                WebElement janCode = driver.findElement(By.id("jan"));
                janCode.sendKeys(product.getJanCode());
                WebElement isbnCode = driver.findElement(By.id("isbn"));
                isbnCode.sendKeys(product.getIsbnCode());
                WebElement gtinCode = driver.findElement(By.id("gtin"));
                gtinCode.sendKeys(product.getGtinCode());
                WebElement mpnCode = driver.findElement(By.id("mpn"));
                mpnCode.sendKeys(product.getMpnCode());
                WebElement googleCategoryDropdown = driver.findElement(By.id("google_category_chosen"));
                googleCategoryDropdown.click();
                WebElement categoryInput = driver.findElement(By.xpath("//*[@id=\"google_category_chosen\"]/div/div/input"));
                categoryInput.sendKeys(product.getGoogleCategory(), Keys.ENTER);

                WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"page_content\"]/form/div[10]/input[3]"));
                saveButton.click();

                takeScreenShot("AddProduct/" + getCurrentTime() + ".jpg");
                WebElement successMessage = driver.findElement(By.className("success"));
                if (successMessage.isDisplayed()) {
                    System.out.println("Product " + product.getProductName() + " Added Successfully.");
                    testStatus = "Passed";
                }
            }
            reportContent.add(new String[]{"2", "AddProduct", "Inventory", "FunctionalTest", getCurrentTime(),
                    getCurrentUser(), testStatus, "-"});

        } catch (Exception e) {
            System.out.println("Add Product Failed!");
            testStatus = "Failed";
            reportContent.add(new String[]{"2", "AddProduct", "Inventory", "FunctionalTest", getCurrentTime(),
                    getCurrentUser(), testStatus, "-"});
        }

    }

    public static void bulkPriceChange(List<Product> productList, String action, int priceValue, String priceType) {
        try {
            WebElement bulkPriceChange = driver.findElement(By.linkText("Bulk Price Change"));
            bulkPriceChange.click();
            for (Product product : productList) {
                WebElement checkBox = driver.findElement(By.xpath(String.format("//td[text()='%s']//parent::tr//following-sibling::td//*[@class='custom-checkbox']", product.getProductCode())));
                checkBox.click();
            }

            WebElement bulkPriceTarget = driver.findElement(By.id("bulk_price_target"));
            Select selectTarget = new Select(bulkPriceTarget);
            selectTarget.selectByVisibleText("Update selected products");

            WebElement bulkPriceMethod = driver.findElement(By.id("bulk_price_method"));
            Select selectMethod = new Select(bulkPriceMethod);
            List<WebElement> options = selectMethod.getOptions();
            for (WebElement element : options) {
                if (element.getText().equalsIgnoreCase("By Amount")) {
                    element.click();
                }
            }

            WebElement actionField = driver.findElement(By.id("bulk_price_action"));
            Select selectAction = new Select(actionField);
            List<WebElement> actions = selectAction.getOptions();
            for (WebElement choose : actions) {
                if (choose.getText().equalsIgnoreCase(action)) {
                    choose.click();
                }
            }

            WebElement input = driver.findElement(By.name("price[value]"));
            input.sendKeys(String.valueOf(priceValue));

            WebElement priceField = driver.findElement(By.name("price[field]"));
            Select selectPriceType = new Select(priceField);
            selectPriceType.selectByValue(priceType);
            sleep();
            WebElement saveButton = driver.findElement(By.xpath("//input[@value=\"Save\"]"));
            saveButton.click();
            takeScreenShot("BulkPriceChange/" + getCurrentTime() + ".jpg");
            WebElement successMessage = driver.findElement(By.className("success"));

            if (successMessage.isDisplayed()) {
                System.out.print("Prices of ");
                for (Product product : productList) {
                    System.out.print(product.getProductName() + ",");
                }
                System.out.println(" have been updated accordingly. ");
                testStatus = "Passed";
                reportContent.add(new String[]{"3", "BulkPriceChange", "Inventory", "FunctionalTest", getCurrentTime(),
                        getCurrentUser(), testStatus, "-"});
            }
        } catch (Exception e) {
            System.out.println("Bulk price change failed!");
            testStatus = "Failed";
            reportContent.add(new String[]{"3", "BulkPriceChange", "Inventory", "FunctionalTest", getCurrentTime(),
                    getCurrentUser(), testStatus, "-"});
        }

    }

    public static void addReview(String productName, List<String> reviewContent) {
        try {
            WebElement reviewsLink = driver.findElement(By.linkText("Reviews"));
            reviewsLink.click();
            WebElement addReview = driver.findElement(By.linkText("Add review"));
            addReview.click();
            WebElement productField = driver.findElement(By.id("ajax_name"));
            productField.sendKeys(productName);
            sleep();

            List<WebElement> optionList = driver.findElements(By.xpath("//ul[@style='list-style: none; margin: 0px; padding: 2px; overflow: hidden;']//li"));
            for (WebElement element : optionList) {
                String s = element.getText();
                if (s.contains(productName)) {
                    element.click();
                    break;
                }
            }
            WebElement statusField = driver.findElement(By.cssSelector(".checkbox.cbs"));
            statusField.click();
            for (int i = 0; i < reviewContent.size(); i++) {
                WebElement nameField = driver.findElement(By.id("review_name"));
                nameField.sendKeys(reviewContent.get(i));

                WebElement emailField = driver.findElement(By.id("review_email"));
                emailField.sendKeys(reviewContent.get(++i));
                WebElement titleField = driver.findElement(By.id("review_title"));
                titleField.sendKeys(reviewContent.get(++i));
                WebElement contentField = driver.findElement(By.id("review_content"));
                contentField.sendKeys(reviewContent.get(++i));
                WebElement starField = driver.findElement(By.xpath(String.format("//a[@title='%s']", reviewContent.get(++i))));
                starField.click();
                break;
            }

            WebElement submit = driver.findElement(By.className("submit"));
            submit.click();

            WebElement successMessage = driver.findElement(By.className("success"));
            if (successMessage.isDisplayed()) {
                System.out.println("Review successfully added.");
                testStatus = "Passed";
                reportContent.add(new String[]{"4", "AddReview", "Inventory", "FunctionalTest", getCurrentTime(),
                        getCurrentUser(), testStatus, "-"});
            }
        } catch (Exception e) {
            System.out.println("Add review failed!");
            testStatus = "Failed";
            reportContent.add(new String[]{"4", "AddReview", "Inventory", "FunctionalTest", getCurrentTime(),
                    getCurrentUser(), testStatus, "-"});
        }
        takeScreenShot("AddReview/" + getCurrentTime() + ".jpg");
    }

    public static void searchReview(String productName) {
        WebElement reviewsLink = driver.findElement(By.linkText("Reviews"));
        reviewsLink.click();
        WebElement searchLink = driver.findElement(By.linkText("Search"));
        searchLink.click();
        WebElement productField = driver.findElement(By.id("search-products"));
        productField.sendKeys(productName);
        sleep();

        List<WebElement> optionList = driver.findElements(By.xpath("//ul[@style='list-style: none; margin: 0px; padding: 2px; overflow: hidden;']//li"));
        for (WebElement element : optionList) {
            String s = element.getText();
            if (s.contains(productName)) {
                element.click();
                break;
            }
        }
        WebElement submit = driver.findElement(By.xpath("//div[@class='form_control']//input[@type='submit']"));
        submit.click();
    }

    public static void updateReview(String productName) {
        try {
            searchReview(productName);
            List<WebElement> editOption = driver.findElements(By.xpath("//span[@class='actions']//a//i[@title='Edit']"));
            for (WebElement element : editOption) {
                element.click();
                break;
            }
            WebElement contentField = driver.findElement(By.id("review_content"));
            contentField.clear();
            contentField.sendKeys("new review content" + timeStamp());
            WebElement starField = driver.findElement(By.xpath(String.format("//a[@title='%s']", String.valueOf((int) (Math.random() * 5 + 1)))));
            starField.click();
            WebElement submitButton = driver.findElement(By.className("submit"));
            submitButton.click();
            WebElement successMessage = driver.findElement(By.className("success"));
            if (successMessage.isDisplayed()) {
                System.out.println("Review successfully updated.");
                testStatus = "Passed";
                reportContent.add(new String[]{"5", "UpdateReview", "Inventory", "FunctionalTest", getCurrentTime(),
                        getCurrentUser(), testStatus, "-"});
            }
        } catch (Exception e) {
            System.out.println("Update review failed!!!");
            testStatus = "Failed";
            reportContent.add(new String[]{"5", "UpdateReview", "Inventory", "FunctionalTest", getCurrentTime(),
                    getCurrentUser(), testStatus, "-"});
        }
        takeScreenShot("UpdateReview/" + getCurrentTime() + ".jpg");
    }

    public static void deleteReview(String productName) {
        try {
            searchReview(productName);
            List<WebElement> deleteIcons = driver.findElements(By.xpath("//span[@class='actions']//i[@title='Delete']"));
            //a[text()='iphone 15 Pro AS']//parent::div//a[text()='email694@gmail.com']//parent::div//parent::div//a[@class='delete']
            for (WebElement element : deleteIcons) {
                element.click();
                break;
            }
            driver.switchTo().alert().accept();
            WebElement successMessage = driver.findElement(By.className("success"));
            takeScreenShot("DeleteReview/" + getCurrentTime() + ".jpg");
            if (successMessage.isDisplayed()) {
                System.out.println("Review successfully deleted.");
                testStatus = "Passed";
                reportContent.add(new String[]{"6", "DeleteReview", "Inventory", "FunctionalTest", getCurrentTime(),
                        getCurrentUser(), testStatus, "-"});
            }
        } catch (Exception e) {
            System.out.println("Delete review failed!");
            testStatus = "Failed";
            reportContent.add(new String[]{"6", "DeleteReview", "Inventory", "FunctionalTest", getCurrentTime(),
                    getCurrentUser(), testStatus, "-"});
        }
    }
}
