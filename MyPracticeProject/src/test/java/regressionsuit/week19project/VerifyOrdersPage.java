package regressionsuit.week19project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class VerifyOrdersPage {
    WebDriver driver;

    public VerifyOrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindAll(
            @FindBy(xpath = "//div[@id='tab_control']//a")
    )
    List<WebElement> allLinks;
    public boolean verifyOrdersPage(){
        int totalLinks= allLinks.size();
      List<String> urls=new ArrayList<>();
      for (WebElement eachLink:allLinks){
          urls.add(eachLink.getAttribute("href"));
      }
      int count=0;
      for(String eachUrl:urls){
          driver.navigate().to(eachUrl);
          System.out.println(driver.getCurrentUrl()+ " tab is displayed");
          count++;
      }
      return totalLinks==count;
    }
}
