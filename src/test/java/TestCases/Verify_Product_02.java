package TestCases;

import Data.Data;
import Objects.CheckoutOverview;
import Objects.Product;
import Pages.*;
import Utils.Constants;
import Utils.Utility;
import org.testng.Assert;
import org.testng.annotations.*;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Verify_Product_02 extends BaseTest {
    LoginPage loginPage;

    @BeforeClass
    @Parameters({"browserName"})
    public void SetUp(@Optional("Chrome") String browserName) {
        super.SetUp(browserName);
        loginPage = new LoginPage(driver);
        loginPage.get(Constants.URL);
        loginPage.login(Data.defaultAccount());
    }

    @Test(priority = 0, description = "Test E2E")
    public void test_e2e() {
        float total_price = 0;
        ProductPage productPage = new ProductPage(driver);
        for (int i = 1; i <= Data.productArrayList().size(); i++) {
            productPage.addProduct(i);
        }

        for (Product product : productPage.getProductInfo()) {
            String price = product.getPrice().replace("$", "");
            float _price = Utility.parseFloat(price);
            total_price += _price;
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

        CheckoutOverview actual_checkoutOverview = checkoutStepTwoPage.get_checkout_overview();

        CheckoutOverview expected_checkoutOverview = Data.checkoutOverview();
        expected_checkoutOverview.setSub_total(expected_checkoutOverview.getSub_total() + total_price);
        expected_checkoutOverview.setTax(expected_checkoutOverview.getTax() + Utility.formatDecimal("#.00", checkoutStepTwoPage.getTax()));
        expected_checkoutOverview.setTotal(expected_checkoutOverview.getTotal() + Utility.formatDecimal("#.00",total_price + checkoutStepTwoPage.getTax()));

        checkoutStepTwoPage.compareCheckoutOverview(actual_checkoutOverview, expected_checkoutOverview);
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