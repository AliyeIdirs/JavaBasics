package regressionsuit.testngproject;

import com.unitedcoder.logging.LoggerForXml;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.List;

public class TestResultListener extends ScreenShotUtility implements ITestListener {
    static List<String> passedTest=new ArrayList<>();
    static List<String> failedTest=new ArrayList<>();
    static List<ITestNGMethod> skippedTest=new ArrayList<>();
    WebDriver driver=null;

    Logger logger=Logger.getLogger(LoggerForXml.class.getName());
    public void onTestStart(ITestResult result) {
        System.out.println(result.getStartMillis());
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    public void onTestSuccess(ITestResult result) {
        passedTest.add(result.getMethod().getMethodName());
        takeScreenshot(driver,result.getMethod().getMethodName().trim()+"_Passed");
        logger.info("passed");
    }
    public void onTestFailure(ITestResult result) {
        failedTest.add(result.getMethod().getMethodName());
        takeScreenshot(driver,result.getMethod().getMethodName().trim()+"_Failed");
        logger.error("Failed");
    }
    public void onTestSkipped(ITestResult result) {
        skippedTest.add(result.getMethod());
    }
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }
    public void onFinish(ITestContext context) {
        System.out.println("Passed Tests: \n"+passedTest);
        System.out.println("Failed Tests: \n"+failedTest);
        System.out.println(context.getEndDate());
    }

}
