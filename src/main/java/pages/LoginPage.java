package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    private final By emailField = By.id("Email");

    private final By Password = By.id("Password");

    private final By loginBtn = By.xpath("//button[contains(text(),'Log in')]");

    public void insertEmail(String txt) {
        sendText(emailField, txt);

    }

    public void insertPassword(String txt) {
        sendText(Password, txt);

    }

    public void clickLoginBtn() {
        bClick(loginBtn);
    }

}
