package Pages;

import Locators.LoginPageLocators;
import Objects.Account;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    /**
     * Login method with account
      * @param account
     */
    public void login (Account account) {
        sendKeys(LoginPageLocators.input_username, account.getUserName());
        sendKeys(LoginPageLocators.input_password, account.getPassword());
        click(LoginPageLocators.element_login_buttons);
    }

    /**
     * Get Login URL
     * @return
     */
    public String getLoginURL() {
        return driver.getCurrentUrl();
    }
}
