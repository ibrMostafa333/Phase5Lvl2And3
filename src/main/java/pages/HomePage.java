package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By loginLink = By.xpath("//*[contains(text(),'Log in')]");
    private final By computersMenu = By.xpath("//*[@class='top-menu notmobile']//a[contains(text(),'Computers')]");
    private final By noteBookSelection = By.xpath("//*[@class='top-menu notmobile']//a[contains(text(),'Notebooks')]");


    public LoginPage clickLoginLink() {
        bClick(loginLink);
        return new LoginPage(driver);
    }

    private void hoverOverComputers() {
        hoverOverEelement(computersMenu);
    }

    private void selectNoteBookPage() {
        clickWithActions(noteBookSelection);

    }

    public NoteBookPage selectNoteBookItem() {
        hoverOverComputers();
        selectNoteBookPage();
        return new NoteBookPage(driver);
    }
}
