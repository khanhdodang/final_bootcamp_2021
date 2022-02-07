package TestCases;

import Data.Data;
import Objects.Account;
import Objects.Product;
import Pages.*;
import Utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class Verify_Product_02 extends BaseTest {
    WebDriver driver;
    Account account = new Account();
    LoginPage loginPage;

    @BeforeClass
    @Parameters({"browserName"})
    public void SetUp(@Optional("Chrome") String browserName) {
        super.SetUp(browserName);
        loginPage = new LoginPage(driver);
        loginPage.get(Constants.URL);
        loginPage.login(Data.defaultAccount());
    }

    @Test(priority = 0, description = "Verify products display correctly")
    public void test_products_display_correctly() {
        ProductPage productPage = new ProductPage(driver);
        for (int i = 1; i <= Data.productArrayList().size(); i++) {
            productPage.addProduct(i);
        }
        CartPage cartPage = new CartPage(driver);
        cartPage.go_to_cart_page();

        ArrayList<Product> arrayList = new ArrayList<Product>();
        for (int i = 1; i <= Data.productArrayList().size(); i++) {
            arrayList.add(Data.productArrayList().get(i - 1));
            productPage.compareProduct(cartPage.getProductInfo(i), Data.productArrayList().get(i - 1));
        }
        cartPage.click_checkout();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.addUserInfo(Data.checkoutInfo());

        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        for (int i = 1; i <= Data.productArrayList().size(); i++) {
            productPage.compareProduct(checkoutStepTwoPage.getProductInfo(i), arrayList.get(i - 1));
        }

        checkoutStepTwoPage.compareCheckoutOverview(checkoutStepTwoPage.get_checkout_overview(), Data.checkoutOverview());
        checkoutStepTwoPage.clickFinish();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertEquals(checkoutCompletePage.get_header_info(), "THANK YOU FOR YOUR ORDER");
        Assert.assertEquals(checkoutCompletePage.get_message_info(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        Assert.assertTrue(checkoutCompletePage.does_image_show());
    }

    @AfterClass
    public void TearDown() {
        super.TearDown();
    }
}