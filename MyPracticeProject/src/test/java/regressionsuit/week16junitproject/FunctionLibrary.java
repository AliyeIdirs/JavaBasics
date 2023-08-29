package regressionsuit.week16junitproject;


import com.github.javafaker.Faker;
import com.unitedcoder.configutility.ApplicationConfig;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class FunctionLibrary extends TestBase{
    static int timeout= Integer.parseInt(ApplicationConfig.readConfigProperties("config.properties","timeout"));
    public static void waitElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitAlertPresent(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public void sleep(){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String timeStamp(){
        long timeStamp= System.currentTimeMillis();
        String time=(Long.toString(timeStamp).toString().substring(10));
        return time;
    }
    String productName= Faker.instance().commerce().productName();
    String manufacturer(){
        List<String> options=new ArrayList<>(Arrays.asList("Amazon Essentials","Crayola","HP","manufacturer1",
                "Mediocre Concrete Table","Practical Concrete Wallet","Rustic Plastic Watch","Small Silk Chair"));
        Random randomOption=new Random();
        String result=options.get(randomOption.nextInt(options.size()));
        return result;
    }
    String condition(){
        List<String> options=new ArrayList<>(Arrays.asList("New","Used","Refurbished","Damaged"));
        Random randomCondition=new Random();
        String result=options.get(randomCondition.nextInt(options.size()));
        return result;
    }
    String productCode=Faker.instance().code().asin()+timeStamp();
    String productWeight=String.valueOf(Faker.instance().number().randomDouble(2,1,100));
    String dimensionUnit(){
        List<String> options=new ArrayList<>(Arrays.asList("Centimeters (cm)","Inches (in)"));
        Random randomDimension=new Random();
        String result=options.get(randomDimension.nextInt(options.size()));
        return result;
    }
    String productWidth=String.valueOf(Faker.instance().number().numberBetween(1,100));
    String productHeight=String.valueOf(Faker.instance().number().numberBetween(1,100));
    String productDepth=String.valueOf(Faker.instance().number().numberBetween(1,100));
    String liveDate(){
        String randomTime=String.valueOf(Faker.instance().date().future(365,TimeUnit.DAYS));
        String[] timeContent=randomTime.split(" ");
        String liveDateValue=timeContent[2]+" "+timeContent[1]+" "+timeContent[5]+" "+timeContent[3];
        return liveDateValue;
    }
    int stockLevel=Faker.instance().number().numberBetween(1,1000);
    int stockLevelWarning=Faker.instance().number().numberBetween(1,20);
    String upcCode =Faker.instance().code().imei();
    String eanCode=Faker.instance().code().ean8();
    String janCode=Faker.instance().code().ean13();
    String isbnCode=Faker.instance().code().isbn13();
    String gtinCode=Faker.instance().code().gtin8();
    String mpnCode=Faker.instance().commerce().promotionCode();
    String googleCategory(){
        List<String> categories=new ArrayList<>(Arrays.asList("Animals & Pet Supplies","Apparel & Accessories > Clothing",
                "Apparel & Accessories > Costumes & Accessories > Costume Shoes","Arts & Entertainment","Baby & Toddler",
                "Business & Industrial","Cameras & Optics","Electronics","Food, Beverages & Tobacco","Furniture",
                "Hardware","Health & Beauty","Home & Garden","Luggage & Bags","Mature","Media","Office Supplies",
                "Religious & Ceremonial","Software","Sporting Goods","Toys & Games","Vehicles & Parts"));
        Random randomCategory=new Random();
        String result=categories.get(randomCategory.nextInt(categories.size()));
        return result;
    }
}
