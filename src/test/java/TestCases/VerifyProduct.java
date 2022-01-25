package testcases;

import data.Data;
import objects.Account;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.BasePage;
import pages.LoginPage;
import pages.ProductPageLocator;
import utils.Utils;

public class VerifyProduct {
    WebDriver driver;
    Account account = new Account();
    LoginPage loginPage;

    @Parameters({"browser"})
    @BeforeTest
    public void SetUp(@Optional("chrome") String browser) {
        System.setProperty("webdriver.chrome.driver", "/Users/doquyen2404/Desktop/Drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/Users/doquyen2404/Desktop/Drivers/geckodriver");
        BasePage basePage = new BasePage(driver);
        super.Setup(browserName);
        loginPage = new LoginPage(driver);
        account = Data.standardUser();
        loginPage.login(account);
    }

    @Test(priority = 0, description = "Verify products display correctly")
    public void test_display_correctly() {
        ProductPageLocator productPageLocator = new ProductPageLocator(driver);
        for (int i = 1; i < Utils.productArrayList().size(); i++) {
            productPageLocator.addProduct(i);
            productPageLocator.removeProduct(i);
            productPageLocator.compareProduct(productPageLocator.getProductInfo(i), Utils.productArrayList().get(i - 1));
        }
    }

    @AfterTest
    public void Teardown() {
        super.Teardown();
    }
}
