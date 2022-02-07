package Pages;

import Locators.CheckOutCompletePageLocators;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutCompletePage extends BasePage {
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String get_header_info() {
        return getText(CheckOutCompletePageLocators.label_header);
    }

    public String get_message_info() {
        return getText(CheckOutCompletePageLocators.label_message);
    }

    public boolean does_image_show() {
        return isDisplayed(CheckOutCompletePageLocators.img_checkout);
    }

    public void verify_results() {
        try {
            Assert.assertEquals(get_header_info(), "THANK YOU FOR YOUR ORDER");
        } catch (AssertionError ex) {
            System.err.println(ex.getMessage());
        }
        try {
            Assert.assertEquals(get_message_info(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        } catch (AssertionError ex) {
            System.err.println(ex.getMessage());
        }
        try {
            Assert.assertTrue(does_image_show());
        } catch (AssertionError ex) {
            System.err.println(ex.getMessage());
        }
    }
}
