package pages;

import org.monte.media.avi.AVIOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class NoteBookPage extends MethodHandles {

    public NoteBookPage(WebDriver driver) {
        super(driver);
    }

    private final By addToCartBtn = By.xpath("(//button[contains(text(),'Add to cart')])[1]");
    private final By finalAddToCart = By.xpath("//div[@class='add-to-cart-panel']//button");
    public void clickAddToCartBtn() {
        bClick(addToCartBtn);
    }

    public void clickFinalAddToCart() {
        bClick(finalAddToCart);
    }

}
