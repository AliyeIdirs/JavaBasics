package regressionsuit.testngproject;

import com.github.javafaker.Faker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class FunctionLibrary {
    WebDriver driver;

    public FunctionLibrary(WebDriver driver) {
        this.driver = driver;
    }

    public void sleep(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void sleep(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void waitForElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public void waitForLocatorPresent(By locator){
        Wait<WebDriver> wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    // usage:
    // By usernameLocator= By.id("username");
    // waitForLocatorPresent(usernameLocator);
    public void waitAlertPresent(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public void waitForElementClickable(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public String readFromConfig(String fileName, String key){
        Properties properties=new Properties();
        FileInputStream fileInputStream;
        try {
            fileInputStream=new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String value= properties.getProperty(key);
        return value;
    }

    public String generateFakeName(int index){
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String[] names={firstName,lastName};
        return names[index];
    }

}
