package Pages;

import Locators.CheckoutStepOnePageLocators;
import Objects.CheckoutInfo;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Check out
     *
     * @param checkoutInfo
     */
    public void checkout(CheckoutInfo checkoutInfo) {
        sendKeys(CheckoutStepOnePageLocators.input_firstname, checkoutInfo.getFirstname());
        sendKeys(CheckoutStepOnePageLocators.input_lastname, checkoutInfo.getLastname());
        sendKeys(CheckoutStepOnePageLocators.input_zipcode, checkoutInfo.getZipcode());
        click(CheckoutStepOnePageLocators.button_continue);
    }

}
