package regressionsuit.junitframework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.spi.AbstractResourceBundleProvider;

public class TestLibrary {
    public static WebDriver driver;
    public static StringBuilder testResult;

    public static void openCubeCart(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        driver.get("http://cubecartuat.unitedcoder.com/admin_tu8sml.php?");
        driver.manage().window().maximize();
        testResult=new StringBuilder();
        testResult.append("TestId,TestName,TestStatus").append("\n");
        if (driver.getTitle().length()!=0)
            testResult.append("001,SiteDisplay,Passed").append("\n");
    }
    public static void login(String userName, String password){
        TestUser testUser=new TestUser(userName,password);
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys(testUser.getUserName());
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(testUser.getPassword());
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        try {
            WebElement dashBoard = driver.findElement(By.xpath("//*[@id=\"dashboard\"]/h3"));
            if (dashBoard.getText().equalsIgnoreCase("dashboard"))
                testResult.append("002,Login Test, Passed").append("\n");

        }
        catch(Exception e) {
            WebElement failMessage= driver.findElement(By.xpath("//li[contains(text(),\"Invalid username or password\")]"));
            if(failMessage.isDisplayed()){
                testResult.append("002,Login Test, Failed").append("\n");
            }
            System.out.println("Login failed.");
        }
    }

    public boolean addPromotionalCode(PromotionalCodeInfo promotionalCodeInfo) {
        WebElement promotionalCodeLink = driver.findElement(By.linkText("Promotional Codes"));
        promotionalCodeLink.click();
        WebElement createPromotionalCodeLink = driver.findElement(By.linkText("Create Promotional Code"));
        createPromotionalCodeLink.click();
        WebElement codeField = driver.findElement(By.id("form-code"));
        codeField.sendKeys(promotionalCodeInfo.getCode());
        WebElement descriptionField = driver.findElement(By.id("form-description"));
        descriptionField.sendKeys(promotionalCodeInfo.getDescription());
        WebElement typeDropdown = driver.findElement(By.id("form-type"));
        Select select = new Select(typeDropdown);
        select.selectByValue("fixed");
        WebElement discountValueField = driver.findElement(By.id("form-value"));
        discountValueField.sendKeys(String.valueOf(promotionalCodeInfo.getDiscountValue()));
        String[] startDateValues = promotionalCodeInfo.getStartDate().split("-");
        sleep(3000);
        startDate(Integer.parseInt(startDateValues[0]), Integer.parseInt(startDateValues[1]), Integer.parseInt(startDateValues[2]));
        String[] expireDateValues = promotionalCodeInfo.getExpiresDate().split("-");
        sleep(3000);
        expireDate(Integer.parseInt(expireDateValues[0]), Integer.parseInt(expireDateValues[1]), Integer.parseInt(expireDateValues[2]));
        WebElement allowedUses = driver.findElement(By.id("form-allowed"));
        allowedUses.sendKeys(promotionalCodeInfo.getAllowedUses());
        WebElement minSubTotalField = driver.findElement(By.id("form-minimum"));
        minSubTotalField.sendKeys(String.valueOf(promotionalCodeInfo.getMinimumSubTotal()));
        WebElement checkBox1 = driver.findElement(By.xpath("//div//label[@for='form-shipping']//parent::div//span//img"));
        checkBox1.click();
        WebElement checkBox2 = driver.findElement(By.xpath("//div//label[@for='form-free_shipping']//parent::div//span//img"));
        checkBox2.click();
        WebElement checkBox3 = driver.findElement(By.xpath("//div//label[@for='form-free_shipping_excluded']//parent::div//span//img"));
        checkBox3.click();
        WebElement checkBox4 = driver.findElement(By.xpath("//div//label[@for='exclude_sale_items']//parent::div//span//img"));
        checkBox4.click();
        WebElement maxUsesField = driver.findElement(By.id("form-coupon_per_customer"));
        maxUsesField.sendKeys("3");
        for(int i=0; i< promotionalCodeInfo.getLimitToManufacturer().size();i++){
            WebElement chooseManufacturer=driver.findElement(By.xpath("//input[@value='Choose manufacturers…']"));
            chooseManufacturer.click();
            WebElement eachManufacturer=driver.findElement(By.xpath(String.format("//ul[@class='chosen-results']/li[text()='%s']",
                    promotionalCodeInfo.getLimitToManufacturer().get(i))));
                eachManufacturer.click();

        }
        WebElement saveButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Save']"));
        saveButton.click();
        if (driver.findElement(By.xpath("//div[text()='Promotional code added.']")).isDisplayed()) {
            testResult.append("003,Add Promotional Code Test, Passes").append("\n");
            return true;
        }else {
            testResult.append("003,Add Promotional Code Test, Failed").append("\n");
            return false;
        }
    }
    public static void startDate(int year,int month, int day){
        WebElement startField=driver.findElement(By.id("form-starts"));
        startField.click();
        WebElement calendar=driver.findElement(By.id("ui-datepicker-div"));
        fluentWait(driver,calendar);
        while(true){
            WebElement yearField=driver.findElement(By.className("ui-datepicker-year"));
            String currentYear=yearField.getText();
            if(Integer.parseInt(currentYear)<year) {
                WebElement nextButton = driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e"));
                nextButton.click();
            }else if(Integer.parseInt(currentYear)>year){
            WebElement prevButton=driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-w"));
            prevButton.click();
            }else{
                break;
            }
        }
        sleep(3000);
        WebElement monthField=driver.findElement(By.className("ui-datepicker-month"));
        Select selectMonth=new Select(monthField);
        selectMonth.selectByValue(String.valueOf(month-1));
        WebElement dayField=driver.findElement(By.xpath(String.format("//a[text()='%s']",(day))));
        dayField.click();
    }
    public static void expireDate(int year,int month,int day) {
        WebElement expireDateField = driver.findElement(By.id("form-expires"));
        expireDateField.click();
        WebElement calendar = driver.findElement(By.className("ui-datepicker-calendar"));
        fluentWait(driver, calendar);
        while(true){
            WebElement yearField = driver.findElement(By.className("ui-datepicker-year"));
            String currentYear = yearField.getText();
            if (Integer.parseInt(currentYear) < year) {
                WebElement nextButton = driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e"));
                nextButton.click();
            }else if(Integer.parseInt(currentYear) > year) {
                WebElement prevButton = driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-w"));
                prevButton.click();
            }else {
                break;
            }
        }
            sleep(3000);
            WebElement monthField = driver.findElement(By.cssSelector(".ui-datepicker-month"));
            Select selectMonth = new Select(monthField);
            selectMonth.selectByValue(String.valueOf(month - 1));
            WebElement dayField = driver.findElement(By.xpath(String.format("//a[text()='%s']", (day))));
            dayField.click();

    }
    public static void logOut(){
        WebElement logoutLink=driver.findElement(By.cssSelector(".fa.fa-sign-out"));
        logoutLink.click();
    }
    public static void closeBrowser(){
        driver.close();
        driver.quit();
    }
    public static void fluentWait(WebDriver driver, WebElement element){
        Wait<WebDriver> wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void sleep(int sec){
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
