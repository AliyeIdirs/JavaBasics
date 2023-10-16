package regressionsuit.pageelementmodel;

import com.unitedcoder.configutility.ApplicationConfig;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author : user
 * @created : 16.10.2023,10:45
 * @Email :aliyeidiris@gmail.com
 **/
public class PageUtility extends BasePage {
    static int timeOut = Integer.parseInt(ApplicationConfig.readConfigProperties("config.properties", "timeout"));
    static int docReadyTimeOut=Integer.parseInt(ApplicationConfig.readConfigProperties("config.properties", "DocumentReadyTimeOut"));

    public static boolean WaitForElementVisible(By by) {
        boolean isElementDisplayed = false;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((by)));
            isElementDisplayed = true;
        } catch (Exception e) {
            System.out.println("Element " + by.toString() + "  is not found within " + timeOut + " seconds");
        }
        return isElementDisplayed;
    }

    public static void WaitForActiveAjaxComplete() {
        StopWatch sw = new StopWatch();
        sw.start();
        try {
            while ((sw.getTime() / 1000) < Integer.parseInt(ApplicationConfig
                    .readConfigProperties("config.properties", "AjaxSyncTimeOut"))){ // Handle timeout
                final JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                boolean ajaxCompleted = (Boolean) javascriptExecutor
                        .executeScript("return window.jQuery != undefined && jQuery.active==0");
                if (ajaxCompleted) {
                    System.out.println("Ajax completed Status is " + ajaxCompleted);
                    System.out.println("Elapsed time is "+ sw.getTime()/1000 +" seconds");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("No Ajax Call");
        } finally {
            sw.stop();
        }
    }

    public static void WaitForDocumentReady() {
        StopWatch sw = new StopWatch();
        sw.start();
        try {
            while ((sw.getTime() / 1000) < docReadyTimeOut) // Handle timeout
            {
                final JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                boolean isDocumentReady = (Boolean) javascriptExecutor.executeScript("return document.readyState==\"complete\"");
                if (isDocumentReady) {
                    System.out.println("Document Ready State:  " + isDocumentReady);
                    System.out.println("Elapsed time is "+ sw.getTime()/1000 +" seconds");
                    break;
                }
            }
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Document is not ready within " + docReadyTimeOut + " seconds");
        } finally {
            sw.stop();
        }
    }

    public static void reloadPage() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("location.reload(true)");
    }
}
