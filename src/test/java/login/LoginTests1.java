package login;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertTrue;

public class LoginTests1 extends BaseTest {

    @DataProvider
    public Object[][] provideDataToTc() throws FileNotFoundException {
        return dataModel().login1;
    }
    @Test(dataProvider = "provideDataToTc")
    public void testSuccessfulLogin(String username,String password) throws FileNotFoundException, InterruptedException {
       LoginPage loginPage =  homePage.clickLoginLink();
       loginPage.insertEmail(username);
       loginPage.insertPassword(password);

//        loginPage.insertEmail(readDataFromJson.readJsonFile().login.validCredentials.username);
//        loginPage.insertPassword(readDataFromJson.readJsonFile().login.validCredentials.password);

//        loginPage.insertEmail(ReaderTestAccount.testUserCredentials.getUsername());
//        loginPage.insertEmail(ReaderTestAccount.testUserCredentials.getPassword());
        loginPage.clickLoginBtn();
        String expectedResult = dataModel().ValidationMessage;
        String actualResult = loginPage.getValidationMessage();
        assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(3000);

    }
}
