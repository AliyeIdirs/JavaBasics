package regressionsuit.testngproject;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.List;

public class TestResultListener extends ScreenShotUtility implements ITestListener {
    static List<String> passedTest=new ArrayList<>();
    static List<String> failedTest=new ArrayList<>();
    static List<ITestNGMethod> skippedTest=new ArrayList<>();
    public void onTestSuccess(ITestResult result) {
        passedTest.add(result.getMethod().getMethodName());
        System.out.println("Passed Tests: \n"+passedTest);

        WebDriver driver=null;
        try {
            driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
          e.printStackTrace();
        }
        takeScreenshot(driver,result.getMethod().getMethodName().trim()+"_Passed");
    }
    public void onTestFailure(ITestResult result) {
        failedTest.add(result.getMethod().getMethodName());
        System.out.println("Failed Tests: \n"+failedTest);
        WebDriver driver=null;
        try {
            driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        takeScreenshot(driver,result.getMethod().getMethodName().trim()+"_Failed");
    }
    public void onTestSkipped(ITestResult result) {
        skippedTest.add(result.getMethod());
    }
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

}
