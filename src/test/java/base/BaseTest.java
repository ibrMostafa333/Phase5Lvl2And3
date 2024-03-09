package base;

import com.beust.jcommander.Parameter;
import data.DataModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import pages.HomePage;
import reader.ReadDataFromJson;
import utils.ScreenRecorderUtil;
import utils.UtilsTests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class BaseTest {

    protected WebDriver driver;
    //protected ReadDataFromJson readDataFromJson;
    protected HomePage homePage;
    ChromeOptions chromeOptions;
    FirefoxOptions firefoxOptions;
    UtilsTests utilsTests;


    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) {
        setUpBrowser(browser);
        homePage = new HomePage(driver);

    }
    @BeforeMethod
    public void goHome(Method method) throws Exception {
        ScreenRecorderUtil.startRecord(method.getName());
        driver.get(dataModel().URL);
    }

    @AfterMethod
    public void afterMethod(Method method) throws Exception {
        utilsTests = new UtilsTests(driver);
        utilsTests.takeScreenshot(method);
        ScreenRecorderUtil.stopRecord();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    protected DataModel dataModel() throws FileNotFoundException {
        ReadDataFromJson readDataFromJson = new ReadDataFromJson();
        return readDataFromJson.readJsonFile();
    }

    @Parameters("browser")
    public void setUpBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("headlessChrome")) {
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);

        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("headlessFirefox")) {
            firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            driver = new FirefoxDriver(firefoxOptions);
        }
        driver.manage().window().maximize();
    }
}
