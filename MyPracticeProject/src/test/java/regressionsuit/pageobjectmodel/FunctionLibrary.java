package regressionsuit.pageobjectmodel;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FunctionLibrary {
    WebDriver driver;

    public FunctionLibrary(WebDriver driver) {
        this.driver = driver;
    }

    public void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void waitForElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public void waitAlertPresent(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public String generateFakeName(int index){
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String[] names={firstName,lastName};
        return names[index];
    }
}
