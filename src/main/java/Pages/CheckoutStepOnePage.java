package Pages;

import Locators.CheckoutStepOnePageLocators;
import Objects.CheckoutInfo;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends BasePage {
    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public void addUserInfo(CheckoutInfo checkoutInfo) {
        sendKeys(CheckoutStepOnePageLocators.input_firstname, checkoutInfo.getFirstname());
        sendKeys(CheckoutStepOnePageLocators.input_lastname, checkoutInfo.getLastname());
        sendKeys(CheckoutStepOnePageLocators.input_zipcode, checkoutInfo.getZipcode());
        clickContinue();
    }

    public void clickCancel() {
        click(CheckoutStepOnePageLocators.button_cancel);
    }

    public void clickContinue() {
        click(CheckoutStepOnePageLocators.button_continue);
    }
}
