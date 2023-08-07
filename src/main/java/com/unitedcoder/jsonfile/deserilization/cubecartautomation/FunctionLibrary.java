package com.unitedcoder.jsonfile.deserilization.cubecartautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class FunctionLibrary {
    static WebDriver driver;

    public static void openBrowser(String url){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver= new ChromeDriver(options);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void login(LoginUser loginUser){
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys(loginUser.getUserName());
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(loginUser.getPassword());
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        takeScreenShot("imageFolder/loginpage"+getCurrentTime()+".jpg");
        try {
            WebElement dashBoard = driver.findElement(By.xpath("//*[@id=\"dashboard\"]/h3"));
            if (dashBoard.getText().equalsIgnoreCase("dashboard"))
                System.out.println("Login Successful");
        }
        catch(Exception e) {
            WebElement failMessage= driver.findElement(By.xpath("//li[contains(text(),\"Invalid username or password\")]"));
            if(failMessage.isDisplayed()){
                System.out.println("Invalid username or password");
            }
            System.out.println("Login failed.");
        }
    }

    public static void takeScreenShot(String imagePath){
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File screenshotFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
        File file=new File(imagePath);
        try {
            FileUtils.copyFile(screenshotFile,file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCurrentTime() {
        DateTime dateTime = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd-HH:mm:ss:SSS");
        return dateTime.toString(formatter);
    }

    public static void logOut(){
            WebElement logOutLink=driver.findElement(By.cssSelector(".fa.fa-sign-out"));
            logOutLink.click();
        }

        public static void tearDown(){
            driver.close();
            driver.quit();
        }
    public static void explicitWait(WebElement element, int timeout){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void addCustomer(Customer customer){
        WebElement customerListLink = driver.findElement(By.linkText("Customer List"));
        customerListLink.click();

        WebElement addCustomerLink = driver.findElement(By.xpath("//a[contains(text(),\"Add Customer\")]"));
        addCustomerLink.click();

        WebElement status = driver.findElement(By.xpath("//img[@rel='#customer_status']"));
        status.click();
        WebElement firstName = driver.findElement(By.name("customer[first_name]"));
        firstName.sendKeys(customer.getFirstName());

        WebElement lastName = driver.findElement(By.id("cust-lastname"));
        lastName.sendKeys(customer.getLastName());
        WebElement email = driver.findElement(By.id("cust-email"));
        email.sendKeys(customer.getEmail());
        WebElement saveButton= driver.findElement(By.name("save"));
        saveButton.click();
        takeScreenShot("imageFolder/addCustomerPage"+getCurrentTime()+".jpg");
        try {
            WebElement successMessage = driver.findElement(By.xpath
                    ("//*[contains(text(),'Customer successfully added.')]"));
            if (successMessage.isDisplayed()) {
                System.out.println(customer.getLastName() + " added successfully");
            }
        }catch (Exception e){
            System.out.println("Add customer Failed!!!");
            e.printStackTrace();
        }
    }

    public static void addProduct(Product product){
        WebElement products=driver.findElement(By.id("nav_products"));
        products.click();
        WebElement addProduct=driver.findElement(By.linkText("Add Product"));
        addProduct.click();
        WebElement productName= driver.findElement(By.id("name"));
        productName.sendKeys(product.getProductName());
        WebElement productCode=driver.findElement(By.id("product_code"));
        productCode.sendKeys(getCurrentTime()+product.getProductCode());
        WebElement manufacturer = driver.findElement(By.id("manufacturer"));
        Select selectManufacturer = new Select(manufacturer);
        explicitWait(manufacturer,3);
        selectManufacturer.selectByVisibleText("manufacturer1");
        WebElement categories= driver.findElement(By.xpath("//a[@href=\"#category\"]"));
        explicitWait(categories,5);
        categories.click();
        WebElement category= driver.findElement(By.name("primary_cat"));
        explicitWait(category,5);
        category.click();

        WebElement saveButton= driver.findElement(By.xpath("//*[@id=\"page_content\"]/form/div[10]/input[3]"));
        saveButton.click();
        takeScreenShot("imageFolder/addProductPage"+getCurrentTime()+".jpg");
        try {
            WebElement successMessage = driver.findElement(By.className("success"));
            if (successMessage.isDisplayed()) {
                System.out.println("Product Added Successfully");
            }
        }catch (Exception e){
            System.out.println("Add Product Failed!");

        }
    }
}
