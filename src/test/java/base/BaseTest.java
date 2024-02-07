package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class BaseTest {

    protected WebDriver driver;
    protected ReadDataFromJson readDataFromJson;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);

    }

    @BeforeMethod
    public void goHome() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        driver.get(readDataFromJson.readJsonFile().URL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
