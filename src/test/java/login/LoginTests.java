package login;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileNotFoundException;

public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() throws FileNotFoundException, InterruptedException {
       LoginPage loginPage =  homePage.clickLoginLink();
        loginPage.insertEmail(readDataFromJson.readJsonFile().login.validCredentials.username);
        loginPage.insertPassword(readDataFromJson.readJsonFile().login.validCredentials.password);
        loginPage.clickLoginBtn();
        Thread.sleep(3000);

    }
}
