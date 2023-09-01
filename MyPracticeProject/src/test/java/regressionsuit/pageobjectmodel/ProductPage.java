package regressionsuit.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }
    @FindBy(linkText = "Add Product")
    WebElement addProductLink;
    @FindAll(
            @FindBy(xpath = "//div[@id='general']/table[3]/tbody/tr")
    )
    List<WebElement> productList;
    public boolean viewProductList(){
        return productList.size()>=1;
    }
}
