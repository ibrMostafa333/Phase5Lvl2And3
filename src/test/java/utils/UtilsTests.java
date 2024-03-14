package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class UtilsTests {

    WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;

    public UtilsTests(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot(Method method) throws IOException {

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("report/" + method.getName() + ".png"));
    }

    public void createReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("report/report.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Phase5 Online Session11");
        extent.attachReporter(spark);
    }

    public void setStatus(Method method, ITestResult testResult) {
        test = extent.createTest(method.getName());
        if (testResult.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else if (testResult.getStatus() == ITestResult.FAILURE) {
            test.fail("Test Failed");

        } else {
            test.skip("Test Skipped");

        }
        test.addScreenCaptureFromPath(method.getName() + ".png");
        test.log(Status.INFO, "<a href='" + method.getName() + "'.avi> Download Video </a>");
    }

    public void flushReport() {
        extent.flush();
    }
}
