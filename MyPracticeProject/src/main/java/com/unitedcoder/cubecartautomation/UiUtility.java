package com.unitedcoder.cubecartautomation;

import com.unitedcoder.configutility.ApplicationConfig;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;

public class UiUtility {
    private WebDriver driver;
    private int timeOut=Integer.parseInt(ApplicationConfig.readConfigProperties("config.properties","timeout"));

    public UiUtility(WebDriver driver, int timeOut) {
        this.driver = driver;
        this.timeOut = timeOut;
    }

    public void waitForElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public static String getCurrentDateTime(){
        DateTime dateTime= new DateTime();
        DateTimeFormatter formatter= DateTimeFormat.forPattern("yyyy-MM-dd-HH:mm:ss:SSS");
        return dateTime.toString(formatter);
    }
    public static String getCurrentHostName(){
        InetAddress localMachine=null;
        try {
            localMachine= InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String hostName= localMachine.getHostName();
        return hostName;
    }
    public static String getCurrentUserName(){
        return System.getProperty("user.name");
    }
    public static String readConfig(String key){
        return ApplicationConfig.readConfigProperties("config.properties",key);
    }
}
