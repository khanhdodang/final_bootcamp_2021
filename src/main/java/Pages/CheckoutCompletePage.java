package Pages;

import Locators.CheckOutCompletePageLocators;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String get_header_info() {
        return getText(CheckOutCompletePageLocators.lable_header);
    }

    public String get_message_info() {
        return getText(CheckOutCompletePageLocators.lable_message);
    }

    public boolean does_image_show() {
        return isDisplayed(CheckOutCompletePageLocators.img_checkout);
    }
}
