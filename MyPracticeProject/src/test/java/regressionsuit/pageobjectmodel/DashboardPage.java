package regressionsuit.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import regressionsuit.testngproject.FunctionLibrary;

public class DashboardPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }

    @FindBy(xpath="//*[@id=\"dashboard\"]/h3")
    WebElement dashBoardText;
    @FindBy(css = ".fa.fa-sign-out")
    WebElement logoutLink;
    @FindBy(linkText = "Customer List")
    WebElement customerListLink;
    @FindBy(linkText = "Categories")
    WebElement categoriesLink;
    @FindBy(linkText = "Products")
    WebElement productsLink;
    @FindBy(linkText = "Images")
    WebElement imagesLink;
    @FindBy(linkText = "Newsletters")
    WebElement newslettersLink;
    @FindBy(linkText = "Orders")
    WebElement ordersLink;
    @FindBy(linkText = "Mailing List")
    WebElement mailingListLink;
    @FindBy(linkText = "Email Log")
    WebElement emailLogLink;
    public boolean verifyLogin(){
        functionLibrary.waitForElementPresent(dashBoardText);
        System.out.println("Dashboard page displayed...");
        return dashBoardText.isDisplayed();
    }

    public void clickCustomerList(){
        functionLibrary.waitForElementPresent(customerListLink);
        customerListLink.click();
    }
    public void clickCategories(){
        functionLibrary.waitForElementPresent(categoriesLink);
        categoriesLink.click();
    }
    public void clickOnProductsLink(){
        functionLibrary.waitForElementPresent(productsLink);
        productsLink.click();
    }
    public void clickOnNewsletters(){
        functionLibrary.waitForElementPresent(newslettersLink);
        newslettersLink.click();
    }

    public void clickOnOrders(){
        functionLibrary.waitForElementPresent(ordersLink);
        ordersLink.click();
    }
    public void clickOnMailingList(){
        functionLibrary.waitForElementPresent(mailingListLink);
        mailingListLink.click();
    }
    public void clickOnEmailLogLink(){
        functionLibrary.waitForElementPresent(emailLogLink);
        emailLogLink.click();
    }
    public void clickOnImagesLink(){
        functionLibrary.waitForElementPresent(imagesLink);
        imagesLink.click();
    }
    public void clickLogOut(){
        functionLibrary.waitForElementPresent(logoutLink);
        logoutLink.click();
    }

}
