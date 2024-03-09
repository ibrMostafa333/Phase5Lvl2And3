package products;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.NoteBookPage;

import static org.testng.Assert.assertTrue;

public class AddItemTests extends BaseTest {

    @Test
    public void testAddToCartSuccessfully() throws InterruptedException {
        NoteBookPage noteBookPage = homePage.selectNoteBookItem();
        //Thread.sleep(3000);
        noteBookPage.clickAddToCartBtn();
        Thread.sleep(3000);
        noteBookPage.clickFinalAddToCart();
        Thread.sleep(3000);
        assertTrue(noteBookPage.barNotificationIsDisplayed());
    }
}
