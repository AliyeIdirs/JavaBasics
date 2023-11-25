package regressionsuit.advancedactions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author : user
 * @created : 31.10.2023,13:23
 * @Email :aliyeidiris@gmail.com
 **/
public class JavaScriptMethods {
    public static void highlightElement(WebElement element, WebDriver driver){
        String backgroundColor=element.getCssValue("backgroundColor");
        for(int i=0; i<10;i++){
            changeColor("#f56942",element,driver);
            changeColor(backgroundColor,element,driver);
        }
    }
    public static void changeColor(String color, WebElement element, WebDriver driver){
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("argument[0].style.backgroundColor='"+color+"'",element);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void setElementBorder(WebElement element, WebDriver driver){
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("argument[0].style.border='4px solid red'",element);

    }
    public static void clickWithJS(WebElement element,WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",element);
        //js.executeScript("document.getElementById('idName').click();");
    }
    public static void sendKeysWithJS(WebElement element,WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("document.getElementById('q').value='software Testing'");
    }
    public static String getTitleWithJS(WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        String title=js.executeScript("return document.title").toString();
        System.out.println(title);
      return title;
    }
    public static void generateAlert(WebDriver driver, String message){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("alert('"+message+"')");
    }
    public static void scrollToElementVisible(WebElement element,WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("argument[0].scrollToView(true);",element);
    }
    public static void refresh(WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("history.go(0)");
    }
}
