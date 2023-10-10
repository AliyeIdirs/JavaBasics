package regressionsuit.pageobjectmodel;

import io.netty.util.internal.StringUtil;
import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import regressionsuit.testngproject.FunctionLibrary;

public class FileManagerPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;

    public FileManagerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }

    @FindBy(linkText = "Upload")
    WebElement uploadLink;
    @FindBy(xpath = "//input[@type='file']")
    WebElement uploadFileButton;

    public boolean uploadImage(String imagePath) {
        functionLibrary.waitForElementPresent(uploadLink);
        uploadLink.click();
        uploadFileButton.sendKeys(imagePath);
        try {
        WebElement image = driver.findElement(By.xpath("//div[@class='dz-image']"));
        functionLibrary.waitForElementPresent(image);
        Actions actions=new Actions(driver);
        actions.moveToElement(image).perform();
        functionLibrary.sleep(3);
        String imageName=(imagePath.split("/"))[imagePath.split("/").length-1];
            WebElement imageContent = driver.findElement(By.xpath
                    (String.format("//div[@class='dz-details']//div[@class='dz-filename']/span[contains(text(),'%s')]"
                            ,imageName )));
            functionLibrary.waitForElementPresent(imageContent);
            if (imageContent.isDisplayed())
                System.out.println("image uploaded");
                return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
