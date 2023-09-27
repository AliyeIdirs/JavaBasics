package regressionsuit.week19project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerifyProductsPage {
    WebDriver driver;

    public VerifyProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindAll(
            @FindBy(xpath = "//div[@id='tab_control']//a")
    )
    List<WebElement> allLinks;
    public boolean verifyProductPage(){
        int status=0;
        List<String> linkTexts=new ArrayList<>(Arrays.asList("Products List","Add Product",
               "Assign to Category","Assign Option Sets","Search Products"));
        for(int i=0; i<allLinks.size();i++){
            if (allLinks.get(i).getText().equalsIgnoreCase(linkTexts.get(i))) {
                System.out.println(allLinks.get(i).getText() + " tab is displayed");
                status=1;
            }else
                status=0;
        }
        return status==1;
    }
}
