package login;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import reader.ReadDataFromJson;
import reader.ReaderTestAccount;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() throws FileNotFoundException, InterruptedException {

       LoginPage loginPage =  homePage.clickLoginLink();
        loginPage.insertEmail(dataModel().login.validCredentials.username);
        loginPage.insertPassword(dataModel().login.validCredentials.password);
//        loginPage.insertEmail(ReaderTestAccount.testUserCredentials.getUsername());
//        loginPage.insertEmail(ReaderTestAccount.testUserCredentials.getPassword());
        loginPage.clickLoginBtn();

        Thread.sleep(3000);

    }
}
