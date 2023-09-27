package regressionsuit.week19project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerifyCustomerListPage {
    WebDriver driver;

    public VerifyCustomerListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindAll(
            @FindBy(xpath = "//div[@id='tab_control']//a")
    )
    List<WebElement> allLinks;
    public boolean verifyCustomerListPage(){
        boolean status=false;
        List<String> linkTexts=new ArrayList<>(Arrays.asList("Customers","Customer Groups","Add Customer",
                "Search Customers"));
        for(int i=0; i<allLinks.size()-1;i++){
            if (allLinks.get(i).getText().equalsIgnoreCase(linkTexts.get(i))){
                System.out.println(allLinks.get(i).getText()+" tab is displayed.");
                status=true;
            }
        }
        return status;
    }
}
