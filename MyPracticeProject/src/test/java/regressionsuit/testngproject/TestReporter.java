package regressionsuit.testngproject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

/**
 * @author : user
 * @created : 15.10.2023,15:25
 * @Email :aliyeidiris@gmail.com
 **/
public class TestReporter implements ITestListener {
    ExtentSparkReporter sparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;
    public void onTestStart(ITestResult result) {
        extentTest=extentReports.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        WebDriver driver=null;
        try {
            driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        extentTest.log(Status.PASS,"Test Passed: "+result.getMethod().getMethodName());
        extentTest.addScreenCaptureFromPath(takeScreenshot(driver,result.getMethod().getMethodName().trim()+"_Passed"));
    }

    public void onTestFailure(ITestResult result) {
        WebDriver driver=null;
        try {
            driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        extentTest.log(Status.INFO,"Error/Exception: "+result.getThrowable());
        extentTest.log(Status.FAIL,"Test Failed:  "+result.getMethod().getMethodName());
        extentTest.addScreenCaptureFromPath(takeScreenshot(driver,result.getMethod().getMethodName().trim()+"_Failed"));
    }

    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP,"Test Skipped: "+result.getMethod().getMethodName());
    }

    public void onStart(ITestContext context) {
        sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+File.separator+"test-output"+File.separator+"report.html");
        sparkReporter.config().setDocumentTitle(context.getSuite().getName()+" Automation Report");
        sparkReporter.config().setReportName(context.getSuite().getName()+" Automation Report");
        sparkReporter.config().setTheme(Theme.DARK);
        extentReports=new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Operating System ", System.getProperty("os.name"));
        extentReports.setSystemInfo("Tester",System.getProperty("user.name"));
    }

    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

    public String takeScreenshot(WebDriver driver,String imageName){
        String sep=File.separator;
        DateTime dateTime = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd_HH:mm:ss");
        String timeStamp = dateTime.toString(formatter);
        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String folderName = System.getProperty("user.dir")+sep+"test-output"+sep+"ScreenCaptured";
        File file = new File(folderName + sep + imageName + "_" + timeStamp + ".png");
        try {
            FileUtils.copyFile(screenShotFile, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file.getAbsolutePath();
    }

}
